package model;

public class Currently {

    private String city;
    private Long time;
    private String summary;
    private String icon;
    private double precipProbability;
    private String precipType;
    private Double temperature;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private double uvIndex;


    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    @Override
    public String toString() {
        return "Currently{" +
                "city='" + city + '\'' +
                ", time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", precipProbability=" + precipProbability +
                ", precipType='" + precipType + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", uvIndex=" + uvIndex +
                '}';
    }
}