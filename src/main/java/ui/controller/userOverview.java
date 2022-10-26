package ui.controller;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class userOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("last" , session.getAttribute("lastAddedUser"));
        request.setAttribute("users", service.getAllUsers());
        request.setAttribute("aantalUsers", service.getNumberOfUsers());
        return "useroverview.jsp";

    }
}
