package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class addProject extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        ArrayList<String> errors = new ArrayList<String>();

        Project project = new Project();
        setProjectNaam(project,request,errors);
        setTeam(project,request,errors);
        setProjectStart(project,request,errors);
        setProjectEinde(project,request,errors);

        if (errors.size() == 0) {
            try {
                service.addProject(project);
                return "Controller?command=projectOverview";
            } catch (DomainException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "addProject.jsp";
    }


    private void setProjectNaam(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String projectNaam = request.getParameter("projectNaam");
        try {
            project.setName(projectNaam);
            request.setAttribute("projectNaamClass", "has-success");
            request.setAttribute("projectNaamPreviousValue", projectNaam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("projectNameClass", "has-error");
        }
    }

    private void setTeam(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String team = request.getParameter("team");
        try {
            project.setTeam(team);
            request.setAttribute("teamClass", "has-success");
            request.setAttribute("teamPreviousValue", team);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("teamClass", "has-error");
        }
    }
    private void setProjectStart(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String start = request.getParameter("start");
        try {
            project.setStart(new SimpleDateFormat("yyyy-dd-MM").parse(request.getParameter("start")));
            request.setAttribute("startClass", "has-success");
            request.setAttribute("startPreviousValue", start);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("startClass", "has-error");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void setProjectEinde(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String einde = request.getParameter("einde");
        try {
            project.setEnd(new SimpleDateFormat("yyyy-dd-MM").parse(request.getParameter("einde")));
            request.setAttribute("eindeClass", "has-success");
            request.setAttribute("eindePreviousValue", einde);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("eindeClass", "has-error");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
