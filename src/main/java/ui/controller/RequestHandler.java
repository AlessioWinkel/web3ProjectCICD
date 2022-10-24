package ui.controller;

import domain.service.AppService;
import domain.service.UserServiceInMemory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public abstract class RequestHandler {
    protected AppService service;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException;

    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }
}
