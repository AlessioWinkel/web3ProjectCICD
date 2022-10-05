package domain.service;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;
import domain.exceptions.DbException;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private final Map<Integer, User> users = new HashMap<Integer, User>();
    private final ArrayList<User> usersArray = new ArrayList<>();
    private int userid = 1;    // als je later werkt met externe databank, wordt dit userid automatisch gegenereerd

    public UserService() {
        User director = new User("director@ucll.be", "t", "Ad", "Director", Team.ALPHA);
        director.setRole(Role.DIRECTOR);
        add(director);
    }

    public User get(int userid) {
        return users.get(userid);
    }

    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }

    public void add(User user) {
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
