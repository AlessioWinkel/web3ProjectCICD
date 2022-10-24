package ui.controller;

import domain.service.AppService;
import domain.service.UserServiceInMemory;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private AppService service = new AppService();

    private HandlerFactory handlerFactory = new HandlerFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination = "index.jsp";
        String command = request.getParameter("command");

        if (command != null) {
            RequestHandler handler = handlerFactory.getHandler(command, service);
            try {
                destination = handler.handleRequest(request, response);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);

    }
}