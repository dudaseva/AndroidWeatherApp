package model;

public class Hourly {

    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "summary='" + summary + '\'' +
                '}';
    }
}
