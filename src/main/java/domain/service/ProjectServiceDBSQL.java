package domain.service;

import domain.exceptions.DbException;
import domain.model.Project;
import domain.model.Team;
import domain.model.User;
import domain.util.DbConnectionService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            preparedStatement.setDate(3, new java.sql.Date(project.getStart().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(project.getEnd().getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void editProject(int id,Date start, Date einde) {
        String sql = String.format("UPDATE %s.project SET start=?, einde=? WHERE projectid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(start.getTime()));
            statement.setDate(2, new java.sql.Date(einde.getTime()));
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
        ArrayList<Project> projects = new ArrayList<>();
        Project project2 = null;
        String sql = String.format("SELECT * from %s.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id2 = result.getInt("projectid");
                String naam = result.getString("naam");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                Date start = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("start"));
                if (result.getString("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Date einde = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("einde"));
                    projects.add(new Project(id2,naam,team,start,einde));
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (id <=0)
            throw new IllegalArgumentException("Foute id ingegeven");
        for (Project project : projects) {
            if (project.getProjectid() == id)
                project2 = project;
        }

        return project2;
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
                Date start = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("start"));
                if (result.getString("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Date einde = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("einde"));
                    projects.add(new Project(id,naam,team,start,einde));
                }



            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
                Date start = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("start"));
                if (result.getString("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Date einde = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("einde"));
                    projects.add(new Project(id,naam,team,start,einde));
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
                Date start = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("start"));
                if (result.getString("einde") == null) {
                    projects.add(new Project(id,naam,team,start,null));
                } else {
                    Date einde = new SimpleDateFormat("yyyy-dd-MM").parse(result.getString("einde"));
                    projects.add(new Project(id,naam,team,start,einde));
                }



            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
