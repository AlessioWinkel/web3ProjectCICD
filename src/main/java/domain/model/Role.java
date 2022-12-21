package domain.model;

public enum Role {
    DIRECTOR("director"), TEAMLEADER("teamleader"), EMPLOYEE("employee");

    private final String stringValue;

    Role(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}
