package homework.che.myspinnerexample;

public class City implements Comparable<City> {

    private int cityID;
    private Country country;
    private State state;
    private String cityName;

    public City(int cityID, Country country, State state, String cityName) {
        this.cityID = cityID;
        this.country = country;
        this.state = state;
        this.cityName = cityName;
    }

    public int getCityID() {
        return cityID;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }

    @Override
    public int compareTo(City another) {
        return this.cityID - another.getCityID();

    }
}
