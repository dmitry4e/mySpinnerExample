package homework.che.myspinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG="myLogs";

    private Spinner country_Spinner;
    private Spinner state_Spinner;
    private Spinner city_Spinner;

    private ArrayAdapter<Country> countryArrayAdapter;
    private ArrayAdapter<State> stateArrayAdapter;
    private ArrayAdapter<City> cityArrayAdapter;

    private ArrayList<Country> countries;
    private ArrayList<State> states;
    private ArrayList<City> cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_Spinner = (Spinner) findViewById(R.id.country_spinner);
        state_Spinner = (Spinner) findViewById(R.id.state_spinner);
        city_Spinner = (Spinner) findViewById(R.id.city_spinner);

        countries = new ArrayList<>();
        states = new ArrayList<>();
        cities = new ArrayList<>();

        createLists();

        countryArrayAdapter = new ArrayAdapter<Country>(getApplicationContext(), R.layout.dropdown_item, countries);
        countryArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
        country_Spinner.setAdapter(countryArrayAdapter);

        stateArrayAdapter = new ArrayAdapter<State>(getApplicationContext(), R.layout.dropdown_item, states);
        stateArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
        state_Spinner.setAdapter(stateArrayAdapter);

        cityArrayAdapter = new ArrayAdapter<City>(getApplicationContext(), R.layout.dropdown_item, cities);
        cityArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
        city_Spinner.setAdapter(cityArrayAdapter);

        country_Spinner.setOnItemSelectedListener(country_listener);
        state_Spinner.setOnItemSelectedListener(state_listener);
        city_Spinner.setOnItemSelectedListener(city_listener);
    }
    private AdapterView.OnItemSelectedListener country_listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position > 0) {
                Country country = (Country) country_Spinner.getItemAtPosition(position);
                Log.d(LOG_TAG, "onItemSelected: country: "+country.getCountryID());
                ArrayList<State> tempStates = new ArrayList<>();

                tempStates.add(new State(0, new Country(0, "Выбор страны"), "Выбор области"));

                for (State singleState : states) {
                    if (singleState.getCountry().getCountryID() == country.getCountryID()) {
                        tempStates.add(singleState);
                    }
                }

                stateArrayAdapter = new ArrayAdapter<State>(getApplicationContext(), R.layout.dropdown_item, tempStates);
                stateArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
                state_Spinner.setAdapter(stateArrayAdapter);
            }

            cityArrayAdapter = new ArrayAdapter<City>(getApplicationContext(), R.layout.dropdown_item, new ArrayList<City>());
            cityArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
            city_Spinner.setAdapter(cityArrayAdapter);
        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private AdapterView.OnItemSelectedListener state_listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position > 0) {
                final State state = (State) state_Spinner.getItemAtPosition(position);
                Log.d(LOG_TAG, "onItemSelected: state: "+state.getStateID());
                ArrayList<City> tempCities = new ArrayList<>();

                Country country = new Country(0, "Выбор страны ");
                State firstState = new State(0, country, "Выбор области");
                tempCities.add(new City(0, country, firstState, "Выбор города"));

                for (City singleCity : cities) {
                    if (singleCity.getState().getStateID() == state.getStateID()) {
                        tempCities.add(singleCity);
                    }
                }

                cityArrayAdapter = new ArrayAdapter<City>(getApplicationContext(), R.layout.dropdown_item, tempCities);
                cityArrayAdapter.setDropDownViewResource(R.layout.dropdown_item);
                city_Spinner.setAdapter(cityArrayAdapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private AdapterView.OnItemSelectedListener city_listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void createLists() {
        Country country0 = new Country(0, "Выберите Страну");
        Country country1 = new Country(1, "Украина");
        Country country2 = new Country(2, "Россия");
        Country country3 = new Country(3, "США");

        countries.add(country0);
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        State state0 = new State(0, country0, "Выберите область");
        State state01 = new State(1, country1, "Киевская");
        State state02 = new State(2, country1, "Запорожская");
        State state03 = new State(3, country1, "Донецкая");
        State state11 = new State(4, country2, "Московская");
        State state12 = new State(5, country2, "Орловская");
        State state13 = new State(6, country2, "Ростовская");
        State state21 = new State(7, country3, "Огайо");
        State state22 = new State(8, country3, "Нью-Йорк");
        State state23 = new State(9, country3, "Калифорния");

        states.add(state0);
        states.add(state01);
        states.add(state02);
        states.add(state03);
        states.add(state11);
        states.add(state12);
        states.add(state13);
        states.add(state21);
        states.add(state22);
        states.add(state23);

        cities.add(new City(0, country0, state0, "Выберите город"));
        cities.add(new City(1, country1, state01, "Киев"));
        cities.add(new City(2, country1, state01, "Бровары"));
        cities.add(new City(3, country1, state01, "Белая Церковь"));
        cities.add(new City(4, country1, state02, "Запорожье"));
        cities.add(new City(5, country1, state02, "Токмак"));
        cities.add(new City(6, country1, state03, "Донецк"));
        cities.add(new City(7, country1, state03, "Дружковка"));
        cities.add(new City(8, country1, state03, "Енакиево"));
        cities.add(new City(9, country2, state11, "City1"));
        cities.add(new City(10, country2, state12, "City2"));
        cities.add(new City(11, country2, state13, "City3"));
        cities.add(new City(12, country3, state21, "City4"));
        cities.add(new City(13, country3, state22, "City5"));
        cities.add(new City(14, country3, state23, "City6"));
        cities.add(new City(15, country3, state21, "City7"));
        cities.add(new City(16, country2, state12, "City8"));
    }
}
