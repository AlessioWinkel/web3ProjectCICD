package domain.service;

import domain.model.Project;
import domain.model.User;
import domain.model.WorkOrder;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class AppService {

    private final WorkOrderService workorders = new WorkOrderServiceDBSQL();
    private final UserService users = new UserServiceDBSQL();
    private final ProjectService projects = new ProjectServiceDBSQL();

    public WorkOrder findWorkOrderById(int id) {return workorders.findWorkOrderById(id);}

    public  ArrayList<WorkOrder> sortWorkOrdersByDate() {return workorders.sortWorkOrdersByDate();}
    public void addWorkOrder(WorkOrder workOrder) {workorders.addWorkOrder(workOrder);}

    public void deleteWorkorder(int id) {workorders.deleteWorkorder(id);}

    public void editWorkOrder(int id, Timestamp date, Time start, Time einde, String description) {workorders.editWorkOrder(id, date,start,einde,description);}

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
