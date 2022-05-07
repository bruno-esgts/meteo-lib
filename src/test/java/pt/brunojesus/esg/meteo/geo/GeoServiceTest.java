package pt.brunojesus.esg.meteo.geo;

import org.junit.jupiter.api.Test;
import pt.brunojesus.esg.meteo.geo.model.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceTest {

    @Test
    void fetchGeolocation() {
        final Coordinate geolocation = new GeoService().fetchGeolocation("Atouguia da Baleia");

        assertNotNull(geolocation);
    }
}