package ui.controller;

import domain.exceptions.DbException;
import domain.exceptions.DomainException;
import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class updateUser extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        String id = request.getParameter("id");

        User user = service.findUserWithId(Integer.parseInt(id));

        setFirstName(user,request,errors);
        setLastName(user,request,errors);
        setEmail(user,request,errors);
        setRole(user,request,errors);
        setTeam(user,request,errors);

        request.setAttribute("user",user);

        if (errors.size() == 0) {
            try {
                return "Controller?command=userOverview";
            } catch (DomainException | DbException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "editUser.jsp";

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
        if (service.zelfdeEmails(email)) {
            errors.add("Er is al een account met dezelfde mail.");
        }
        try {
            user.setEmail(email);
            request.setAttribute("emailClass", "has-success");
            request.setAttribute("emailPreviousValue", email);
        }
        catch (IllegalArgumentException | DbException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("emailClass", "has-error");
        }

    }

    private void setRole(User user, HttpServletRequest request, ArrayList<String> errors) {
        String role = request.getParameter("role");
        try {
            user.setRole(Role.valueOf(role.toUpperCase()));
            request.setAttribute("roleClass", "has-success");
            request.setAttribute("rolePreviousValue", role);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("roleClass", "has-error");
        }

    }
}
