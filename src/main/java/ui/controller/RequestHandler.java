package ui.controller;

import domain.model.User;
import domain.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public abstract class RequestHandler {
    protected UserService service;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException;

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
