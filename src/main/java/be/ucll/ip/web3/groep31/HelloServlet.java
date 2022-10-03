package be.ucll.ip.web3.groep31;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;

        String command = request.getParameter("command");

        if (command == null) {
            destination = getIndex(request);
        } else {
            switch (command) {
                case "userOverview":
                    destination = getUserOverview(request, response);
                    break;
                case "Games":
                    destination = registerForm(request, response);
                    break;
            }

        }
    }

    private String registerForm(HttpServletRequest request, HttpServletResponse response) {
        return "register.jsp";
    }

    private String getUserOverview(HttpServletRequest request, HttpServletResponse response) {
        return "useroverview.jsp";
    }

    private String getIndex(HttpServletRequest request) {
        return "index.jsp";
    }
}