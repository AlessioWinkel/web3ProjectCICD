package domain.model;

import domain.exceptions.DomainException;

import java.sql.Time;
import java.sql.Timestamp;

public class WorkOrder {
    private int workorderid,userid;
    private String username;
    private Team team;
    private Timestamp date;
    private Time start,end;
    private long duration;
    private String description;


    public WorkOrder(int userid,String username, Team team,Timestamp date, Time start, Time end, String description) {
        setDescription(description);
        setEnd(end);
        setStart(start);
        setUsername(username);
        setUserid(userid);
        setTeam(team);
        setDate(date);
        setDuration(start,end);
    }
    public WorkOrder() {};

    public WorkOrder(int workorderid, int userid,String username, Team team,Timestamp date, Time start, Time end, String description) {
        setDescription(description);
        setDate(date);
        setEnd(end);
        setStart(start);
        setUsername(username);
        setUserid(userid);
        setWorkorderid(workorderid);
        setTeam(team);
        setDuration(start,end);
    }


    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public void setEnd(Time end) {
        if (end.toLocalTime().isBefore(this.start.toLocalTime())) {
            throw new IllegalArgumentException("End time must be before start!");
        }
        this.end = end;
    }

    public void setDescription(String description) {
        if (description.length() > 100) {
            throw new IllegalArgumentException("Lengte mag maximaal 100 characters zijn");
        }
        this.description = description;
    }

    public void setDuration(Time start, Time end) {
        if (end.toLocalTime().isBefore(start.toLocalTime())) {
            throw new IllegalArgumentException("End time must be before start!");
        }
        this.duration = end.getTime() - start.getTime();
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
