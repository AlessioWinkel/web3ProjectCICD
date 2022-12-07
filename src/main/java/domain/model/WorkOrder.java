package domain.model;

import domain.exceptions.DomainException;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkOrder {
    private int workorderid,userid;
    private String username;
    private Team team;
    private Timestamp date;
    private Time start,end;
    private long duration;
    private String description;


    public WorkOrder(int userid,String username, Team team,Timestamp date, Time start, Time end, String description) throws ParseException {
        setDate(date);
        setStart(start);
        setEnd(end);
        setUsername(username);
        setUserid(userid);
        setTeam(team);
        setDuration(start,end);
        setDescription(description);
    }
    public WorkOrder() {};

    public WorkOrder(int workorderid, int userid,String username, Team team,Timestamp date, Time start, Time end, String description) throws ParseException {

        setWorkorderid(workorderid);
        setDate(date);
        setStart(start);
        setEnd(end);
        setUsername(username);
        setUserid(userid);
        setTeam(team);
        setDuration(start,end);
        setDescription(description);
    }


    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStart(Time start) {
        if (start == null) throw new IllegalArgumentException("Starttijd mag niet leeg zijn");
        this.start = start;
    }

    public void setEnd(Time end) throws ParseException {
        if (end == null) throw new IllegalArgumentException("Eindtijd mag niet leeg zijn");
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("HH:mm:ss");
        Date date1 = simpleDateFormat.parse(String.valueOf(this.start));
        Date date2 = simpleDateFormat.parse(String.valueOf(end));
        if (date2.before(date1)) throw new IllegalArgumentException("Eind tijd moet na starttijd liggen!");
        this.end = end;
    }

    public void setDescription(String description) {
        if (description.length() > 100 || description.isEmpty()) {
            throw new IllegalArgumentException("Lengte mag maximaal 100 characters zijn en mag niet leeg zijn!");
        }
        this.description = description;
    }

    public void setDuration(Time start, Time end) throws ParseException {
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("HH:mm:ss");
        Date date1 = simpleDateFormat.parse(String.valueOf(start));
        Date date2 = simpleDateFormat.parse(String.valueOf(end));
        long differenceInMilliSeconds
                = Math.abs(date2.getTime() - date1.getTime());
        differenceInMilliSeconds = differenceInMilliSeconds / 60000;
        this.duration = differenceInMilliSeconds;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username mag niet leeg zijn");
        }
        this.username = username;
    }

    public void setWorkorderid(int workorderid) {
        this.workorderid = workorderid;
    }

    public Team getTeam() {
        return team;
    }

    public int getUserid() {
        return userid;
    }

    public int getWorkorderid() {
        return workorderid;
    }

    public long getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no team with value " + team);
        }
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        if (date == null) throw new IllegalArgumentException("datum mag niet leeg zijn");
        this.date = date;
    }

    public String getTeamString() {return team.getStringValue();}

    public Time getEnd() {
        return end;
    }

    public Time getStart() {
        return start;
    }
}
