package domain.service;

import domain.exceptions.DbException;
import domain.model.Project;
import domain.model.Team;
import domain.model.WorkOrder;
import domain.util.DbConnectionService;
import domain.util.PasswordHashing;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class WorkOrderServiceDBSQL implements WorkOrderService{

    private final Connection connection;

    private final String schema;

    public WorkOrderServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }
    @Override
    public ArrayList<WorkOrder> getAllWorkOrders() {
        ArrayList<WorkOrder> workorders = new ArrayList<>();
        String sql = String.format("SELECT * from %s.workorder", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int workorderId = result.getInt("workorder_id");
                int userId = result.getInt("userid");
                String username = result.getString("username");
                String teamString = result.getString("userteam");
                Team team = Team.valueOf(teamString.toUpperCase());
                Timestamp datum = result.getTimestamp("datum");
                Time start = result.getTime("start_time");
                Time einde = result.getTime("end_time");
                String description = result.getString("description");
                workorders.add(new WorkOrder(workorderId,userId,username,team,datum,start,einde,description));

            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return workorders;
    }

    @Override
    public void editWorkOrder(int id,Timestamp date, Time start, Time einde, String description) {
        String sql = String.format("UPDATE %s.workorder SET date=?, start_time=?, end_time=?, description=? WHERE workorder_id=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setTimestamp(1, date);
            statement.setTime(2, start);
            statement.setTime(3,einde);
            statement.setString(4,description);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteWorkorder(int id) {
        String sql = String.format("DELETE from %s.workorder WHERE workorder_id=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void addWorkOrder(WorkOrder workOrder) {
        String query = String.format("insert into %s.workorder (userid,username,userteam,datum,start_time,end_time,description) values (?,?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setInt(1, workOrder.getUserid());
            preparedStatement.setString(2, workOrder.getUsername());
            preparedStatement.setString(3, workOrder.getTeamString());
            preparedStatement.setTimestamp(4, workOrder.getDate());
            preparedStatement.setTime(5, workOrder.getStart());
            preparedStatement.setTime(6, workOrder.getEnd());
            preparedStatement.setString(7, workOrder.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
