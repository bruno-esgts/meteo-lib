package pt.brunojesus.esg.meteo.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

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

    public Date getTime() {
        return time;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

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
}
