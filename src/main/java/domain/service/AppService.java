package domain.service;


import domain.model.Project;
import domain.model.User;
import domain.model.WorkOrder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class AppService {

    private WorkOrderService workorders = new WorkOrderServiceDBSQL();
    private UserService users = new UserServiceDBSQL();
    private ProjectService projects = new ProjectServiceDBSQL();

    public void addWorkOrder(WorkOrder workOrder) {workorders.addWorkOrder(workOrder);}

    public ArrayList<WorkOrder> getAllWorkOrders() {return workorders.getAllWorkOrders();}

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
    public boolean zelfdeEmails2(String email) {
        return users.zelfdeEmails(email);
    }

    public boolean zelfdeProjectNaam(String projectNaam) {return projects.zelfdeProjectNaam(projectNaam);}

    public Object getNumberOfProjects() { return projects.getNumberOfProjects();
    }

    public void deleteProject(int id) {projects.deleteProject(id);}

    public void editProject(int id, Timestamp start, Timestamp end) {projects.editProject(id,start,end);
    }
}
