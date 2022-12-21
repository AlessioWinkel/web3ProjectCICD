package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class courseOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        request.setAttribute("users", service.getAllUsers());
        request.setAttribute("aantalUsers", service.getNumberOfUsers());
        return "useroverview.jsp";

    }
}
