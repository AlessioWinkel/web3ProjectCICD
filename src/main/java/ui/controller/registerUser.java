package ui.controller;

import domain.exceptions.DomainException;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class registerUser extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        User user = new User();
        setFirstName(user,request,errors);
        setLastName(user,request,errors);
        setEmail(user,request,errors);
        setPassword(user,request,errors);
        setTeam(user,request,errors);

        if (errors.size() == 0) {
            try {
                service.add(user);
                return "Controller?command=userOverview";
            } catch (DomainException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "register.jsp";

    }

    private void setTeam(User user, HttpServletRequest request, ArrayList<String> errors) {
        String team = request.getParameter("team");
        try {
            user.setTeam(team);
            request.setAttribute("teamClass", "has-success");
            request.setAttribute("teamPreviousValue", team);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("teamClass", "has-error");
        }
    }
    private void setFirstName(User user, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try {
            user.setFirstName(firstName);
            request.setAttribute("firstNameClass", "has-success");
            request.setAttribute("firstNamePreviousValue", firstName);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("firstNameClass", "has-error");
        }
    }
    private void setLastName(User user, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            user.setLastName(lastName);
            request.setAttribute("lastNameClass", "has-success");
            request.setAttribute("lastNamePreviousValue", lastName);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("lastNameClass", "has-error");
        }
    }

    private void setEmail(User user, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            user.setEmail(email);
            request.setAttribute("emailClass", "has-success");
            request.setAttribute("emailPreviousValue", email);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("emailClass", "has-error");
        }
    }

    private void setPassword(User user, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            user.setPassword(password);
            request.setAttribute("passwordClass", "has-success");
            request.setAttribute("passwordPreviousValue", password);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("passwordClass", "has-error");
        }
    }

}
