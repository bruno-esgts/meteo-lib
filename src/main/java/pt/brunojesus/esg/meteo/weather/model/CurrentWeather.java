package pt.brunojesus.esg.meteo.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

/**
 * Represents the current weather conditions
 * Meant to be used as part of a {@link Weather} object
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-05-07
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    private final Date time;
    private final Integer windDirection;
    private final Integer windSpeed;
    private final Double temperature;

    public CurrentWeather(
            @JsonProperty("time") Date time,
            @JsonProperty("winddirection") Integer windDirection,
            @JsonProperty("windspeed") Integer windSpeed,
            @JsonProperty("temperature") Double temperature) {
        this.time = time;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
    }

    /**
     * The time of the weather information
     *
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * The wind direction in degrees
     *
     * @return wind direction
     */
    public Integer getWindDirection() {
        return windDirection;
    }

    /**
     * The wind speed in Km/h
     *
     * @return wind direction
     */
    public Integer getWindSpeed() {
        return windSpeed;
    }

    /**
     * The temperature in Celsius
     *
     * @return temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeather that = (CurrentWeather) o;
        return Objects.equals(time, that.time) && Objects.equals(windDirection, that.windDirection) && Objects.equals(windSpeed, that.windSpeed) && Objects.equals(temperature, that.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, windDirection, windSpeed, temperature);
    }

    @Override
    public String toString() {
        return "CurrentWeather{" + "time=" + time +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                ", temperature=" + temperature +
                '}';
    }
}
