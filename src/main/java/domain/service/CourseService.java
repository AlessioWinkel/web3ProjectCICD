package domain.service;

import domain.model.Course;
import domain.model.Project;

import java.util.ArrayList;

public interface CourseService {
    void addCourse(Course course);
    void addLector(String lector);
    ArrayList<Course> getAllCourses();
    void deleteCourses(String name);

}
