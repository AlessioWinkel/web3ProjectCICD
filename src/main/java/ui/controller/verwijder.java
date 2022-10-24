package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class verwijder extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service",service);
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteUser(id);
        return "useroverview.jsp";
    }
}
