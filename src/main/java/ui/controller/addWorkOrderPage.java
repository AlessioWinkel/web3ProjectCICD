package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class addWorkOrderPage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        return "addWorkOrder.jsp";
    }
}
