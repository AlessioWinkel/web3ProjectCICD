package ui.controller;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class verwijder extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service",service);
        request.setAttribute("users",service.getAllUsers());
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteUser(id);
        return "Controller?command=userOverview";
    }
}
