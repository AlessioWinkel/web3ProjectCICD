package domain.service;

import domain.exceptions.DbException;
import domain.model.Course;

import domain.util.DbConnectionService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseServiceDBSQL implements CourseService{
    private final Connection connection;
    private final String schema;

    public CourseServiceDBSQL(){
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addCourse(Course course) {
        String query = String.format("insert into %s.course (name,lector,credit) values (?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getLectorsString());
            preparedStatement.setInt(3, course.getCredits());

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    private Connection getConnection() {
        return this.connection;
    }

    @Override
    public void addLector(String lector) {
        //TODO

        /*String sql = String.format("UPDATE %s.course set lectors=? WHERE name=?", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);


            preparedStatement.setString(1, lectorString);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> course = new ArrayList<>();
        String sql = String.format("SELECT * from %s.course", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                // String terug omzetten naar list

                String lectorsString = result.getString("lectors");
                ArrayList<String> lectors = new ArrayList<String>(Arrays.asList(lectorsString.split(",")));

                int credits = result.getInt("credits");
                course.add(new Course(name, lectors, credits));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return course;
    }

    @Override
    public void deleteCourses(String name) {
        String sql = String.format("DELETE from %s.user WHERE name=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
