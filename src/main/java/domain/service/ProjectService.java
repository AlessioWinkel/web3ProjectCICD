package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public interface ProjectService {
    void addProject(Project project);

    Project findProjectWithName(String naam);

    ArrayList<Project> getAllProjects();

    Object getNumberOfProjects();

    void deleteProject(int id);
}
