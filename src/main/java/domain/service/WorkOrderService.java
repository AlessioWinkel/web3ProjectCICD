package domain.service;

import domain.model.WorkOrder;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface WorkOrderService {

    ArrayList<WorkOrder> getAllWorkOrders();

    void editWorkOrder(int id,Timestamp date, Time start, Time einde, String description);

    WorkOrder findWorkOrderById(int id);

    ArrayList<WorkOrder> sortWorkOrdersByDate();

    void deleteWorkorder(int id);

    void addWorkOrder(WorkOrder workOrder);
}
