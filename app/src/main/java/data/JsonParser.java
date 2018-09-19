package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.CurrentWeather;



public class JsonParser {

    public static CurrentWeather getWeather(String data) {

        CurrentWeather currentWeather;

        Gson gson = new Gson();
        currentWeather = (CurrentWeather) gson.fromJson(data, CurrentWeather.class);


        //Gson gsonbuilder = new GsonBuilder()
        // .setDateFormat("YY mm dd HH:mm").create();

        return currentWeather;



    }
}
