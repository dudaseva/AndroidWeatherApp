package model;

public class CurrentWeather {

    private Double latitude;
    private Double longitude;
    private Currently currently;
    private Hourly hourly;
    private Daily daily;

    public CurrentWeather() {
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }


    @Override
    public String toString() {
        return "CurrentWeather{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", currently=" + currently +
                ", hourly=" + hourly +
                ", daily=" + daily +
                '}';
    }
}
