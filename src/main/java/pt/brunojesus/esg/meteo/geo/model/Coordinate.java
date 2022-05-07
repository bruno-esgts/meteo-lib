package pt.brunojesus.esg.meteo.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents a coordinate for the Geolocation API
 *
 * @author Bruno Jesus
 * @since 2022-05-07
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {

    private final double latitude;
    private final double longitude;

    public Coordinate(
            @JsonProperty("latt") double latitude,
            @JsonProperty("longt") double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * The latitude
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * The longitude
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
