package model;


public class City {

    private String countryName;
    private String cityName;
    private String stateName;
    private Coordinate coords;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }
}
