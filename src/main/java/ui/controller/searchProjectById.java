package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class searchProjectById extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, ParseException {
        ArrayList<String> errors = new ArrayList<>();
        int id = 0;

        if (Objects.equals(request.getParameter("projectId"), "")) {
            errors.add("Geef een geldige id in!");
        } else {
            id = Integer.parseInt(request.getParameter("projectId"));
        }

        if (id <= 0) {
            errors.add("Geef een positieve id in!");
        }

        if (errors.size() == 0) {
            try {
                Project project = service.findProjectWithId(id);
                request.setAttribute("project", project);
                response.sendRedirect("Controller?command=Home");
                return "Controller?command=Home";
            } catch (DomainException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);

        return "Controller?command=Home";
    }
}
