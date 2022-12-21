package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class sortWorkOrdersByDate extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, ParseException {
        boolean activated = true;
        request.setAttribute("activated", activated);
        request.setAttribute("sortedWorkOrders",service.sortWorkOrdersByDate());
        request.setAttribute("aantalWorkOrders", service.getAllWorkOrders().size());
        return "workOrderOverview.jsp";
    }
}
