package homework.che.myspinnerexample;

import java.util.List;

public class State implements Comparable<State> {

    private int stateID;
    private Country country;
    private String stateName;

    public State(int stateID, Country country, String stateName) {
        this.stateID = stateID;
        this.country = country;
        this.stateName = stateName;
    }

    public int getStateID() {
        return stateID;
    }

    public Country getCountry() {
        return country;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return stateName;
    }

    @Override
    public int compareTo(State another) {
        return this.getStateID() - another.getStateID();//ascending order
//            return another.getStateID()-this.getStateID();//descending order
    }
}
