package domain.model;

import domain.exceptions.DomainException;
import domain.service.ProjectServiceDBSQL;
import domain.service.UserServiceDBSQL;
import domain.util.PasswordHashing;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private int userid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Team team;
    private Role role;




    public User(String email, String password, String firstName, String lastName, Team team) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setTeam(team);
        setRole("employee");

    }
    public User(String email, String password, String firstName, String lastName, Team team,String role) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setTeam(team);
        setRole(role);

    }


    public User(int userid, String email, String password, String firstName, String lastName, Team team,String role) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this(email, password, firstName, lastName, team,role);
        this.setUserid(userid);
    }







    public User() {
        setRole("employee");
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private static String sha512(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        return PasswordHashing.hashPassword(password);
    }



    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("No email given");
        }


        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCorrectPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        return getPassword().equals(password);
    }

    public void setPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("No firstname given");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("No last name given");
        }
        this.lastName = lastName;
    }

    public Team getTeam() {
        return team;
    }

    public String getTeamString() {return team.getStringValue();}

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no team with value " + team);
        }
    }

    public String getRoleString() {return this.role.getStringValue();}

    public Role getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role.toUpperCase());
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ": " + getUserid() + ", " + getEmail() + ", " + getRole() + ", " + getTeam();
    }
    public boolean isPasswordCorrect(String password){
        return password != null && password.equals(getPassword());
    }
}
