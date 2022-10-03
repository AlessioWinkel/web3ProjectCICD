package db;

import domain.DomainException;
import domain.Team;
import domain.User;

import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private int sequence = 0;
    private final List<User> users = new ArrayList<>();
    private int verwijderCount = 0;



    public UserDB() {

        this.add(new User("alessio@gmail.com","password1","alessio","winkel",Team team));
    }



    public void add(User user) {
        if (user == null)
            throw new DomainException("Geen geldige user om toe te voegen");
        this.sequence++;
        user.setUserid(sequence);
        users.add(user);
    }

    public User getUserById(int id) {
        for (User user : users)
            if (user.getUserid() == id)
                return user;
        throw new DomainException("Er is geen user met gegeven id");
    }

    public int countUsers() {
        return users.size();
    }
}
