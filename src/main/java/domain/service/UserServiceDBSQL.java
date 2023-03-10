package domain.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.exceptions.DbException;
import domain.model.Role;
import domain.model.Team;
import domain.model.User;
import domain.util.DbConnectionService;
import domain.util.PasswordHashing;

public class UserServiceDBSQL implements UserService{
    private final Connection connection;

    private final String schema;

    public UserServiceDBSQL() {

        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addUser(User user) {
        String query = String.format("insert into %s.user (email,password,first_name,last_name,team,role) values (?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, PasswordHashing.hashPassword(user.getPassword()));
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getTeamString());
            preparedStatement.setString(6, "EMPLOYEE");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }


    @Override
    public User findUserWithName(String naam) {
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = String.format("SELECT * from %s.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("userid");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                String role = result.getString("role");
                users.add(new User(id,email,password,firstName,lastName,team,role));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public int getNumberOfUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = String.format("SELECT * from %s.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("userid");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                String role = result.getString("role");
                users.add(new User(id,email,password,firstName,lastName,team,role));
            }
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage());
        }
        return users.size();
    }

    @Override
    public User findUserWithId(int id) {
        ArrayList<User> users = new ArrayList<>();
        User user2 = null;
        String sql = String.format("SELECT * from %s.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id2 = result.getInt("userid");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                String role = result.getString("role");
                users.add(new User(id2,email,password,firstName,lastName,team,role));
            }
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage());
        }
        if (id <=0)
            throw new IllegalArgumentException("Foute id ingegeven");
        for (User user : users) {
            if (user.getUserid() == id)
                user2 = user;
        }

        return user2;
    }


    @Override
    public boolean zelfdeEmails(String email) {

        ArrayList<User> users = new ArrayList<>();
        String sql = String.format("SELECT * from %s.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("userid");
                String email2 = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String teamString = result.getString("team");
                Team team = Team.valueOf(teamString.toUpperCase());
                String role = result.getString("role");
                users.add(new User(id,email2,password,firstName,lastName,team,role));
            }
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage());
        }

        boolean zelfde = false;
        int count = 0;
        for (User user1 : users) {
            if (user1.getEmail().equals(email)) {
                count++;
            }
        }
        if (count > 0) {
            zelfde = true;
        }
        return zelfde;
    }

    public void delete(int id) {
        String sql = String.format("DELETE from %s.user WHERE userid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void updateUser(int id,String firstName, String lastName, String email, String team, String role) {

        String sql = String.format("UPDATE %s.user SET first_name=?, last_name=?, email=?, team=?, role=? WHERE userid=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, team);
            statement.setString(5, role);
            statement.setInt(6,id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private Connection getConnection() {
        return this.connection;
    }
}
