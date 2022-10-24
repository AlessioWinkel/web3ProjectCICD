package domain.model;

import domain.exceptions.DomainException;

import java.time.LocalDate;
import java.util.Date;

public class Project {
    private int projectid;
    private String name;
    private Team team;
    private Date start,end;

    public Project(String name, Team team, Date start, Date end) {
        setName(name);
        setStart(start);
        setEnd(end);
        setTeam(String.valueOf(team));
    }
    public Project() {};

    public String getTeamString() {return team.getStringValue();}
    public int getProjectid() {
        return projectid;
    }

    public Date getEnd() {
        return end;
    }

    public Date getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public Project(int projectid, String name, Team team, Date start, Date end) {
        this(name,team,start,end);
        this.setProjectid(projectid);
    }



    public void setEnd(Date end) {
        this.end = end;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("No name given");
        }
        this.name = name;
    }

    public void setStart(Date start) {
        if (start == null) {
            throw new IllegalArgumentException("Datum mag niet leeg zijn");
        }
        this.start = start;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no team with value " + team);
        }
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
