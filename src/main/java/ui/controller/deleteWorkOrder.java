package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class deleteWorkOrder extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, ParseException {
            int id = Integer.parseInt(request.getParameter("workOrderId"));
            service.deleteWorkorder(id);
            return "Controller?command=workOrderOverviewPage";
    }
}
