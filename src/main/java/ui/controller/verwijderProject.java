package ui.controller;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class verwijderProject extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        request.setAttribute("service",service);
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteProject(id);
        return "Controller?command=projectOverview";
    }
}
