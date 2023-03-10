package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Project;
import domain.model.User;
import domain.model.WorkOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class addWorkOrder extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, ParseException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        ArrayList<String> errors = new ArrayList<String>();

        WorkOrder workOrder = new WorkOrder();
        setWorkOrderDatum(workOrder, request, errors);
        setWorkOrderStart(workOrder, request, errors);
        setWorkOrderEinde(workOrder, request, errors);
        setWorkOrderUserId(workOrder, user, request, errors);
        setWorkOrderUserName(workOrder, user, request, errors);
        setWorkOrderTeam(workOrder, user, request, errors);
        setWorkOrderDescription(workOrder, request, errors);

        if (errors.size() == 0) {
            try {
                service.addWorkOrder(workOrder);
                response.sendRedirect("Controller?command=workOrderOverviewPage");
                return "Controller?command=workOrderOverviewPage";
            } catch (IllegalArgumentException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=addWorkOrderPage";
    }

    private void setWorkOrderDescription(WorkOrder workOrder, HttpServletRequest request, ArrayList<String> errors) {
        String workOrderDescription = request.getParameter("description");
        try {
            workOrder.setDescription(workOrderDescription);
            request.setAttribute("descriptionClass", "has-success");
            request.setAttribute("descriptionPreviousValue", workOrderDescription);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("descriptionClass", "has-error");
        }
    }

    private void setWorkOrderEinde(WorkOrder workOrder, HttpServletRequest request, ArrayList<String> errors) throws ParseException {
        String einde = request.getParameter("endTime");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Time ppstime;

        if (Objects.equals(einde, "")) {
            ppstime = null;
        } else {
            Date d1 = format.parse(einde);
            ppstime = new Time(d1.getTime());
        }
        try {
            workOrder.setEnd(ppstime);
            request.setAttribute("endTimeClass", "has-success");
            request.setAttribute("endTimePreviousValue", einde);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("endTimeClass", "has-error");
        }
    }

    private void setWorkOrderStart(WorkOrder workOrder, HttpServletRequest request, ArrayList<String> errors) throws ParseException {
        String start = request.getParameter("startTime");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Time ppstime;

        if (Objects.equals(start, "")) {
            ppstime = null;
        } else {
            Date d1 = format.parse(start);
            ppstime = new Time(d1.getTime());
        }


        try {
            workOrder.setStart(ppstime);
            request.setAttribute("startTimeClass", "has-success");
            request.setAttribute("startTimePreviousValue", start);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("startTimeClass", "has-error");
        }
    }

    private void setWorkOrderDatum(WorkOrder workOrder, HttpServletRequest request, ArrayList<String> errors) {
        String dateFromHtml = request.getParameter("date");
        String dateTimeFromHtml = request.getParameter("dateTime");
        String dateAndTime = (dateFromHtml + " " + dateTimeFromHtml);
        Timestamp dateTimeStamp;
        if (dateAndTime.equals(" ") || dateAndTime.equals(dateFromHtml + " ") || dateAndTime.equals(" " + dateTimeFromHtml)) {
            dateTimeStamp = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
            dateTimeStamp = Timestamp.valueOf(dateTime);
        }
        try {
            workOrder.setDate(dateTimeStamp);
            request.setAttribute("dateClass", "has-success");
            request.setAttribute("datePreviousValue", dateFromHtml);
            request.setAttribute("dateTimePreviousValue", dateTimeFromHtml);

        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("dateClass", "has-error");
        }
    }

    private void setWorkOrderTeam(WorkOrder workOrder, User user, HttpServletRequest request, ArrayList<String> errors) {
        String team = user.getTeamString();
        try {
            workOrder.setTeam(team);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setWorkOrderUserId(WorkOrder workOrder, User user, HttpServletRequest request, ArrayList<String> errors) {
        int userid = user.getUserid();
        try {
            workOrder.setUserid(userid);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setWorkOrderUserName(WorkOrder workOrder, User user, HttpServletRequest request, ArrayList<String> errors) {
        String username = user.getFirstName();
        try {
            workOrder.setUsername(username);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }
}
