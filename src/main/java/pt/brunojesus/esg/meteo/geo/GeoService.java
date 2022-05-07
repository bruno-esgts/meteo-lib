package pt.brunojesus.esg.meteo.geo;


import pt.brunojesus.esg.meteo.exception.CityNotFoundException;
import pt.brunojesus.esg.meteo.geo.model.Coordinate;
import pt.brunojesus.esg.meteo.mapping.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

/**
 * Handles GeoLocation requests
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-05-07
 */
public class GeoService {

    private static final String API_URL = "https://geocode.xyz/%s?json=1";

    /**
     * Fetches the coordinates for a given city using the Geocode API
     *
     * @param city the city name to get the coordinates
     * @return the coordinates for the given city
     * @throws CityNotFoundException if we can't fetch the city information from the API
     */
    public Coordinate fetchCoordinates(String city) throws CityNotFoundException {
        final Coordinate result;

        try {
            result = doRequest(city);
        } catch (IOException | InterruptedException e) {
            throw new CityNotFoundException("Cannot find city", e);
        }

        return result;
    }

    private Coordinate doRequest(String city) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();

        final HttpRequest request = HttpRequest.newBuilder(
                        URI.create(String.format(API_URL, URLEncoder.encode(city, StandardCharsets.UTF_8)))
                )
                .header("accept", "application/json")
                .build();

        final var response = client.send(request, new JsonBodyHandler<>(Coordinate.class));

        return response.body().get();
    }
}
