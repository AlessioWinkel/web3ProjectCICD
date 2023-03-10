package domain.service;

import domain.model.User;

import java.util.ArrayList;

public interface UserService {
    void addUser(User user);
    void delete(int id);

    void updateUser(int id,String firstName, String lastName, String email, String team, String role);

    User findUserWithName(String naam);

    ArrayList<User> getAllUsers();

    int getNumberOfUsers();

    User findUserWithId(int id);

    boolean zelfdeEmails(String email);

}
