package model;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;


public class Daily {
    ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data {
        float sunriseTime;
        float sunsetTime;
        float temperatureHigh;
        float temperatureLow;

        public float getSunriseTime() {
            return sunriseTime;
        }

        public void setSunriseTime(float sunriseTime) {
            this.sunriseTime = sunriseTime;
        }

        public float getSunsetTime() {
            return sunsetTime;
        }

        public void setSunsetTime(float sunsetTime) {
            this.sunsetTime = sunsetTime;
        }

        public float getTemperatureHigh() {
            return temperatureHigh;
        }

        public void setTemperatureHigh(float temperatureHigh) {
            this.temperatureHigh = temperatureHigh;
        }

        public float getTemperatureLow() {
            return temperatureLow;
        }

        public void setTemperatureLow(float temperatureLow) {
            this.temperatureLow = temperatureLow;
        }
    }

}





