package model;

import java.util.ArrayList;


public class Daily {
    ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data {
        long sunriseTime;
        long sunsetTime;
        float temperatureHigh;
        float temperatureLow;

        public long getSunriseTime() {
            return sunriseTime;
        }

        public void setSunriseTime(long sunriseTime) {
            this.sunriseTime = sunriseTime;
        }

        public long getSunsetTime() {
            return sunsetTime;
        }

        public void setSunsetTime(long sunsetTime) {
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





