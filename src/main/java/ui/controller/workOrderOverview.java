package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class workOrderOverview extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        request.setAttribute("aantalWorkOrders",service.getAllWorkOrders().size());
        request.setAttribute("workOrders",service.getAllWorkOrders());
        return "workOrderOverview.jsp";
    }
}
