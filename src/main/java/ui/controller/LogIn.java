package ui.controller;

import domain.model.User;
import domain.util.PasswordHashing;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;


public class LogIn extends RequestHandler {

    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        email = email.toLowerCase(Locale.ROOT);
        String password = request.getParameter("password");
        String passwordHashed = PasswordHashing.hashPassword(password);
        for (User u : service.getAllUsers()) {
            if (u.getEmail().toLowerCase(Locale.ROOT).equals(email)) {
                if (u.isCorrectPassword(passwordHashed)) {
                    session.setAttribute("user", u);
                } else {
                    request.setAttribute("fout", "No valid email/password");
                }
                return "Controller?command=Home";
            }
        }
        request.setAttribute("fout", "No valid email/password");
        return "Controller?command=Home";
    }

}
