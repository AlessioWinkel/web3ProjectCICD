package domain.service;


import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public class AppService {
    private UserService users = (UserService) new UserServiceDBSQL();
    private ProjectService projects = new ProjectServiceDBSQL();

    public void addProject(Project project) {projects.addProject(project);}

    public ArrayList<Project> getAllProjects() {return projects.getAllProjects();}

    public void addUser(User user) {users.addUser(user);}
    public void deleteUser(int id) {users.delete(id);}

    public User findUserWithId(int id) {
        return users.findUserWithId(id);
    }

    public ArrayList<User> getAllUsers() {
        return users.getAllUsers();
    }

    public int getNumberOfUsers() {return users.getNumberOfUsers();}

    public boolean zelfdeEmails(String email) {
        return users.zelfdeEmails(email);
    }

    public Object getNumberOfProjects() { return projects.getNumberOfProjects();
    }

    public void deleteProject(int id) {projects.deleteProject(id);}
}
