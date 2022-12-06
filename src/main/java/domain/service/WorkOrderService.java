package domain.service;

import domain.model.WorkOrder;

import java.util.ArrayList;

public interface WorkOrderService {

    ArrayList<WorkOrder> getAllWorkOrders();

    void addWorkOrder(WorkOrder workOrder);
}
