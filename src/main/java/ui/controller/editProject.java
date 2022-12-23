package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Project;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class editProject extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        ArrayList<String> errors = new ArrayList<String>();

        int id = Integer.parseInt(request.getParameter("id"));

        Project project = service.findProjectWithId(id);

        setProjectStart(project,request,errors);
        setProjectEinde(project,request,errors);


        request.setAttribute("project",project);

        if (errors.size() == 0) {
            try {
                service.editProject(id,project.getStart(),project.getEnd());
                response.sendRedirect("Controller?command=projectOverview");
                return "Controller?command=projectOverview";
            } catch (DomainException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "editProject.jsp";
    }

    private void setProjectStart(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String dateFromHtml = request.getParameter("start");
        String dateTimeFromHtml = request.getParameter("startTime");
        String dateAndTime = (dateFromHtml + " " + dateTimeFromHtml);
        Timestamp dateTimeStamp;
        if (dateAndTime.equals(" ") || (dateAndTime.equals(" " + dateTimeFromHtml)) || dateAndTime.equals(dateFromHtml + " ")) {
            dateTimeStamp = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
            dateTimeStamp = Timestamp.valueOf(dateTime);
        }
        try {
            project.setStart(dateTimeStamp);
            request.setAttribute("startClass", "has-success");
            request.setAttribute("startPreviousValue", dateTimeStamp);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("startClass", "has-error");
        }
    }

    private void setProjectEinde(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String dateFromHtml = request.getParameter("einde");
        String dateTimeFromHtml = request.getParameter("eindeTime");
        String dateAndTime = (dateFromHtml + " " + dateTimeFromHtml);
        Timestamp dateTimeStamp;
        if (dateAndTime.equals(" ")) {
            dateTimeStamp = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
            dateTimeStamp = Timestamp.valueOf(dateTime);
        }
        try {
            project.setEnd(dateTimeStamp);
            request.setAttribute("eindeClass", "has-success");
            request.setAttribute("eindePreviousValue", dateTimeStamp);

        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("eindeClass", "has-error");
        }
    }
}
