package domain.service;

import domain.exceptions.DbException;
import domain.model.Project;
import domain.model.Team;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProjectServiceInMemory implements ProjectService {
    private final Map<Integer, Project> projects = new HashMap<Integer, Project>();
    private final ArrayList<Project> projectsArray = new ArrayList<>();
    private int projectid = 1;

    public ProjectServiceInMemory() {};

    @Override
    public void addProject(Project project) {
        if (project == null) {
            throw new DbException("No project given");
        }

        if (projects.containsKey(project.getProjectid())) {
            throw new DbException("Project already exists");
        }
        project.setProjectid(projectid);   // user toevoegen geeft altijd nieuw userid
        projects.put(project.getProjectid(), project);
        projectsArray.add(project);
        projectid++;
    }

    @Override
    public void editProject(int id, Timestamp start, Timestamp einde) {

    }

    @Override
    public Project findProjectWithId(int id) {
        Project project2 = new Project();
        for (Project project : projectsArray) {
            if (project.getProjectid() == id) {
                project2 = project;
            }
        }
        return project2;
    }

    @Override
    public boolean zelfdeProjectNaam(String projectNaam) {
        return false;
    }

    @Override
    public ArrayList<Project> getAllProjects() {
        return projectsArray;
    }

    @Override
    public Object getNumberOfProjects() {
        return projectsArray.size();
    }

    @Override
    public void deleteProject(int id) {

    }
}
