package domain.service;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;
import domain.exceptions.DbException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceInMemory implements UserService {
    private final Map<Integer, User> users = new HashMap<Integer, User>();
    private final ArrayList<User> usersArray = new ArrayList<>();
    private int userid = 1;    // als je later werkt met externe databank, wordt dit userid automatisch gegenereerd

    public UserServiceInMemory() {
        User director = new User("director@ucll.be", "t", "Ad", "Director", Team.ALPHA);
        director.setRole(Role.DIRECTOR);
        addUser(director);
    }
    @Override
    public User findUserWithName(String firstName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("Naam mag niet leeg zijn");
        for (User user : usersArray) {
            if (user.getFirstName().equals(firstName))
                return user;
        }
        return null;
    }


    @Override
    public ArrayList<User> getAllUsers() {
        return usersArray;
    }

    @Override
    public User findUserWithId(int id) {
        if (id <=0)
            throw new IllegalArgumentException("Foute id ingegeven");
        for (User user : usersArray) {
            if (user.getUserid() == id)
                return user;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        boolean sameEmail = false;
        if (user == null) {
            throw new DbException("No user given");
        }
        for (User user1 : usersArray) {
            if (user.getEmail().equals(user1.getEmail())) {
                sameEmail = true;
            }
        }
        if (sameEmail) throw new DbException("A user with this email already exists");

        if (users.containsKey(user.getUserid())) {
            throw new DbException("User already exists");
        }
        user.setUserid(userid);   // user toevoegen geeft altijd nieuw userid
        users.put(user.getUserid(), user);
        usersArray.add(user);
        userid++;
    }

    public boolean zelfdeEmails(String email) {
        boolean zelfde = false;
        int count = 0;
        for (User user1 : usersArray) {
            if (user1.getEmail().equals(email)) {
                count++;
            }
        }
        if (count >= 1) {
            zelfde = true;
        }
        return zelfde;
    }

    public void update(User user) {
        if (user == null) {
            throw new DbException("No user given");
        }
        if (!users.containsKey(user.getUserid())) {
            throw new DbException("No user found");
        }
        users.put(user.getUserid(), user); // user updaten: userid blijft behouden
    }

    public void delete(int userid) {
        users.remove(userid);   // userid gaat verloren, maar wordt niet ingenomen door eventuele nieuwe user
    }

    public int getNumberOfUsers() {
        return users.size();
    }
}
