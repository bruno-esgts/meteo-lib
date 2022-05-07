package pt.brunojesus.esg.meteo.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the weather for a specific location
 *
 * @author Bruno Jesus
 * @since 2022-05-07
 * @version 1.0
 */
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

    /**
     * The latitude
     *
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * The longitude
     *
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Gets the elevation in meters
     *
     * @return the elevation
     */
    public Double getElevation() {
        return elevation;
    }

    /**
     * The current weather conditions
     *
     * @return current weather conditions
     */
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

    @Override
    public String toString() {
        return "Weather{" + "latitude=" + latitude +
                ", longitude=" + longitude +
                ", elevation=" + elevation +
                ", currentWeather=" + currentWeather +
                '}';
    }
}
