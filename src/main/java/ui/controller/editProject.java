package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Project;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                return "Controller?command=projectOverview";
            } catch (DomainException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "editProject.jsp";
    }

    private void setProjectStart(Project project, HttpServletRequest request, ArrayList<String> errors) {
        String start = request.getParameter("start");
        try {
            project.setStart(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z").parse(start));
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
            project.setEnd(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z").parse(einde));
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
