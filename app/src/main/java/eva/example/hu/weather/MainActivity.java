package eva.example.hu.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import data.JsonParser;
import data.WeatherHttpClient;
import model.CurrentWeather;

public class MainActivity extends AppCompatActivity {

    private TextView city;
    private TextView icon;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (TextView) findViewById(R.id.txtCity);
        //icon = (ImageView) findViewById(R.id.image);
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

        renderWeatherData("37.1234,50.34");
        // renderWeatherData("17.1234,10.34");
        //  37.1234,50.34
        //Szeged: 46.253, 20.14824
    }

    public void renderWeatherData (String city) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city});
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

          //city.setText(currentWeather.getLatitude());
          //icon.setText(currentWeather.getCurrently().getIcon() + "")
          // maxTemperature
          // minTemperature

          temperature.setText(Math.round((currentWeather.getCurrently().getTemperature()-32)*5/9) + "°C");
          summary.setText(currentWeather.getHourly().getSummary() + "");
          uvIndex.setText("UV: " + Math.round(currentWeather.getCurrently().getUvIndex()) + "");
          humidity.setText("Humidity: " + Math.round((currentWeather.getCurrently().getHumidity())*100) + " %");
          pressure.setText("Pressure: " + Math.round(currentWeather.getCurrently().getPressure()) + " mBar");
          // sunrise.setText(currentWeather.getDaily());
          // sunset.setText(currentWeather.getDaily());
          precipitation.setText("Precipitation: " + currentWeather.getCurrently().getPrecipType() + "");
          precipProbability.setText("Probability: " + Math.round(currentWeather.getCurrently().getPrecipProbability()*100) + " %");
          windSpeed.setText("Windspeed: " + Math.round(currentWeather.getCurrently().getWindSpeed()) + " km/h");
          updated.setText("Last updated: " + currentWeather.getCurrently().getTime() + "");


      }
  }



}






