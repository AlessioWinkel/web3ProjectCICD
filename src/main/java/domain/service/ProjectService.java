package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;
import java.util.Date;

public interface ProjectService {
    void addProject(Project project);

    void editProject(int id,Date start, Date einde);
    Project findProjectWithId(int id);

    boolean zelfdeProjectNaam(String projectNaam);

    ArrayList<Project> getAllProjects();

    Object getNumberOfProjects();

    void deleteProject(int id);
}
