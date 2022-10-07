package ui.controller;

import domain.model.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class LogIn extends RequestHandler{

    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        ArrayList<String> errors = new ArrayList<>();

        login(request,response,errors);
        if (errors.size() == 0){

            return "index.jsp";
        }
        else {
            request.setAttribute("errors", errors);
            return "index.jsp";
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) throws IOException, NoSuchAlgorithmException {

        ArrayList<User> values = new ArrayList(service.getAll());
        request.setAttribute("users", values);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (email.isEmpty()){
            errors.add("No e-mail given.");
        }
        if (!email.isEmpty() && !values.contains(email)){
            errors.add("Unkown e-mail.");
        }

        if (!email.isEmpty() && values.contains(email)){
            for(User u : values){
                if (u != null){
                    if (u.getEmail().equalsIgnoreCase(email)){

                        if (!password.isEmpty() && u.isPasswordCorrect(password)){

                           // TO DO
                        }
                         else if (!password.isEmpty() && !u.isCorrectPassword(password)){
                             errors.add("Wrong password");
                         }
                    }
                }
            }
        }

        if (password.isEmpty()){
            errors.add("No password given.");
        }

    }

}
