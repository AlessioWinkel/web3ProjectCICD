package domain.service;


import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;
import java.util.Date;

public class AppService {
    private UserService users = (UserService) new UserServiceDBSQL();
    private ProjectService projects = new ProjectServiceDBSQL();

    public void addProject(Project project) {projects.addProject(project);}

    public ArrayList<Project> getAllProjects() {return projects.getAllProjects();}

    public Project findProjectWithId(int id) {return projects.findProjectWithId(id);}

    public void addUser(User user) {users.addUser(user);}
    public void deleteUser(int id) {users.delete(id);}

    public void updateUser(int id,String firstName, String lastName, String email, String team, String role) {
        users.updateUser(id,firstName,lastName,email,team,role);
    }

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

    public void editProject(int id,Date start, Date end) {projects.editProject(id,start,end);
    }
}
