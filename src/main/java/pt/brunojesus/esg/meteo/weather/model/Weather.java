package pt.brunojesus.esg.meteo.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private final Double latitude;
    private final Double longitude;
    private final Double elevation;
    private final CurrentWeather currentWeather;

    public Weather(
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude,
            @JsonProperty("elevation") Double elevation,
            @JsonProperty("current_weather") CurrentWeather currentWeather) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.currentWeather = currentWeather;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getElevation() {
        return elevation;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(latitude, weather.latitude) && Objects.equals(longitude, weather.longitude) && Objects.equals(elevation, weather.elevation) && Objects.equals(currentWeather, weather.currentWeather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, elevation, currentWeather);
    }
}
