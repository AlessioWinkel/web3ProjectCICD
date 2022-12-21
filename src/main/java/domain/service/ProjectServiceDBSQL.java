package domain.service;

import domain.exceptions.DbException;
import domain.model.Project;
import domain.model.Team;
import domain.model.User;
import domain.model.WorkOrder;
import domain.util.DbConnectionService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProjectServiceDBSQL implements ProjectService{

    private final Connection connection;

    private final String schema;

    public ProjectServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }
    @Override
    public void addProject(Project project) {
        String query = String.format("insert into %s.project (naam,team,start,einde) values (?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getTeamString());
            preparedStatement.setTimestamp(3, project.getStart());
            preparedStatement.setTimestamp(4, project.getEnd());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void editProject(int id, Timestamp start, Timestamp einde) {
        String sql = String.format("UPDATE %s.project SET start=?, einde=? WHERE projectid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setTimestamp(1, start);
            statement.setTimestamp(2, einde);
            statement.setInt(3,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteProject(int id) {
        String sql = String.format("DELETE from %s.project WHERE projectid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Project findProjectWithId(int id) {
        Project project = null;
        if (id <=0)
            throw new IllegalArgumentException("Foute id ingegeven");
        ArrayList<Project> projects = new ArrayList<>();
        Project project2 = null;
        String sql = String.format("SELECT * from %s.project where projectid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id2 = result.getInt("projectid");
                String naam = result.getString("naam");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                Timestamp start =  result.getTimestamp("start");
                if (result.getTimestamp("einde") == null) {
                    project = new Project(id,naam,team,start,null);
                } else {
                    Timestamp einde = result.getTimestamp("einde");
                    project = new Project(id2,naam,team,start,einde);
                }
            }
        } catch (SQLException | IllegalArgumentException e) {
            throw new DbException(e.getMessage());
        }


        return project;
    }

    @Override
    public ArrayList<Project> getAllProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        String sql = String.format("SELECT * from %s.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("projectid");
                String naam = result.getString("naam");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                Timestamp start =  result.getTimestamp("start");
                if (result.getTimestamp("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Timestamp einde = result.getTimestamp("einde");
                    projects.add(new Project(id,naam,team,start,einde));
                }



            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return projects;
    }

    @Override
    public Object getNumberOfProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        String sql = String.format("SELECT * from %s.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("projectid");
                String naam = result.getString("naam");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                Timestamp start =  result.getTimestamp("start");
                if (result.getTimestamp("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Timestamp einde = result.getTimestamp("einde");
                    projects.add(new Project(id,naam,team,start,einde));
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } 
        return projects.size();
    }

    public boolean zelfdeProjectNaam(String naamProject) {

        ArrayList<Project> projects = new ArrayList<>();
        String sql = String.format("SELECT * from %s.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("projectid");
                String naam = result.getString("naam");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                Timestamp start =  result.getTimestamp("start");
                if (result.getTimestamp("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Timestamp einde = result.getTimestamp("einde");
                    projects.add(new Project(id,naam,team,start,einde));
                }

            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        boolean zelfde = false;
        int count = 0;
        for (Project project : projects) {
            if (project.getName().equals(naamProject)) {
                count++;
            }
        }
        if (count > 0) {
            zelfde = true;
        }
        return zelfde;
    }

    public Connection getConnection() {
        return connection;
    }
}
