package homework.che.myspinnerexample;

public class Country implements Comparable<Country> {

    private int countryID;
    private String countryName;

    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return countryName;
    }


    @Override
    public int compareTo(Country another) {
        return this.getCountryID() - another.getCountryID();

    }
}
