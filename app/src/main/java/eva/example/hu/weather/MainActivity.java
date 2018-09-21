package eva.example.hu.weather;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import data.JsonParser;
import data.WeatherHttpClient;
import model.CurrentWeather;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private TextView city;
//    private TextView icon;
    private TextView temperature;
    private TextView summary;
    private TextView maxtemperature;
    private TextView mintemperature;
    private TextView uvIndex;
    private TextView humidity;
    private TextView pressure;
    private TextView sunrise;
    private TextView sunset;
    private TextView precipitation;
    private TextView precipProbability;
    private TextView windSpeed;
    private TextView updated;

    CurrentWeather currentWeather = new CurrentWeather();

    static Map<String, String> cities;
     static {
         cities = new HashMap<String, String>();

        cities.put("Szeged", "46.253, 20.14824");
        cities.put("Kecskemét", "46.908, 19.692");
        cities.put("Budapest", "47.494245, 19.054058");
        cities.put("Siófok", "46.253, 20.14824");
        cities.put("Hódmezővásárhely", "46.409474, 20.316926");
        cities.put("Debrecen", "47.551594, 21.626078");
        cities.put("Kecel", "46.526044, 19.246017");
        cities.put("Barcelona", "41.375705, 2.190133");
        cities.put("Oslo", "59.913929, 10.752629");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        city = (TextView) findViewById(R.id.txtCity);
//        icon = (ImageView) findViewById(R.id.image);
        temperature = (TextView) findViewById(R.id.curr_temperature);
        summary = (TextView) findViewById(R.id.summaryText);
        maxtemperature = (TextView) findViewById(R.id.max_temperature);
        mintemperature = (TextView) findViewById(R.id.min_temperature);
        uvIndex = (TextView) findViewById(R.id.uvIndex);
        humidity = (TextView) findViewById(R.id.humidity);
        pressure = (TextView) findViewById(R.id.pressure);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);
        precipitation = (TextView) findViewById(R.id.precipitation);
        precipProbability = (TextView) findViewById(R.id.precipProbability);
        windSpeed = (TextView) findViewById(R.id.windSpeed);
        updated = (TextView) findViewById(R.id.lastUpdated);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.citiesXml, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        renderWeatherData(text);
        ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#ACE9E7"));
        ((TextView) parent.getChildAt(0)).setTextSize(25);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void renderWeatherData (String city) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(cities.get(city));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private class WeatherTask extends AsyncTask<String, Void, CurrentWeather> {

      @Override
      protected CurrentWeather doInBackground(String... params) {

          String data = new WeatherHttpClient().getWeatherData(params[0]);
          currentWeather = JsonParser.getWeather(data);
          return currentWeather;
      }

      @Override
      protected void onPostExecute(CurrentWeather currentWeather) {

          super.onPostExecute(currentWeather);
          if (currentWeather == null) {
              return;
          }

          String updatedDateformat = new SimpleDateFormat("HH:mm").format(new Date());
          String sunriseDateformat = new SimpleDateFormat("HH:mm").format(new Date(currentWeather.getDaily().getData().get(0).getSunriseTime() * 1000));
          String sunsetDateformat = new SimpleDateFormat("HH:mm").format(new Date(currentWeather.getDaily().getData().get(0).getSunsetTime() * 1000));
          
          //icon.setText(currentWeather.getCurrently().getIcon() + "")

          maxtemperature.setText("⇧ " + Math.round((currentWeather.getDaily().getData().get(0).getTemperatureHigh()-32)*5/9) + "°C");
          mintemperature.setText("⇩" + Math.round((currentWeather.getDaily().getData().get(0).getTemperatureLow()-32)*5/9) + "°C");
          temperature.setText(Math.round((currentWeather.getCurrently().getTemperature()-32)*5/9) + "°C");
          summary.setText(currentWeather.getHourly().getSummary() + "");
          uvIndex.setText("UV: " + Math.round(currentWeather.getCurrently().getUvIndex()) + "");
          humidity.setText("Humidity: " + Math.round((currentWeather.getCurrently().getHumidity())*100) + " %");
          pressure.setText("Pressure: " + Math.round(currentWeather.getCurrently().getPressure()) + " mBar");
          sunrise.setText("Sunrise: " + sunriseDateformat + "");
          sunset.setText("Sunset: " + sunsetDateformat + "");
          precipitation.setText("Precipitation: " + currentWeather.getCurrently().getPrecipType() + "");
          precipProbability.setText("Probability: " + Math.round(currentWeather.getCurrently().getPrecipProbability()*100) + " %");
          windSpeed.setText("Windspeed: " + Math.round(currentWeather.getCurrently().getWindSpeed()) + " km/h");
          updated.setText("Last updated: " + updatedDateformat);
      }
  }
}






