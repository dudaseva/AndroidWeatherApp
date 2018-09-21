package data;
import com.google.gson.Gson;
import model.CurrentWeather;

public class JsonParser {

    public static CurrentWeather getWeather(String data) {

        CurrentWeather currentWeather;

        Gson gson = new Gson();
        currentWeather = (CurrentWeather) gson.fromJson(data, CurrentWeather.class);

        return currentWeather;
    }
}
