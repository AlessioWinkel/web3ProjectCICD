package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private ArrayList<String> lectors = new ArrayList<String>();
    private int credits;

    public Course(String name, ArrayList<String> lectors, int credits){
        setName(name);
        this.lectors = lectors;
        setCredits(credits);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank())
            throw new IllegalArgumentException("vaknaam mag niet leeg zijn");
        this.name = name;
    }

    public ArrayList<String> getLectors() {
        return lectors;
    }

    public String getLectorsString() {
            String ret="";
            for (int i=0; i< lectors.size(); i++) {
                if (i==0)
                    ret += (String)this.lectors.get(i);
                else
                    ret += "," + (String)lectors.get(i);
            }
            return ret;
        }

    public void addLectors(String lector) {
        if(lector.isBlank())
            throw new IllegalArgumentException("lectornaam mag niet leeg zijn");
        this.lectors.add(lector);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if(credits <3)
            throw new IllegalArgumentException("Credits moet meer dan 3 zijn");
        this.credits = credits;
    }
    public String[] arrayLectors(){
        return this.lectors.toArray(new String[lectors.size()]);
    }
}
