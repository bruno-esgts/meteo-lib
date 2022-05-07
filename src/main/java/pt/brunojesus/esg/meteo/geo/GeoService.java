package pt.brunojesus.esg.meteo.geo;


import pt.brunojesus.esg.meteo.geo.model.Coordinate;
import pt.brunojesus.esg.meteo.mapping.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class GeoService {

    public Coordinate fetchGeolocation(String city) {
        final Coordinate result;

        try {
            result = doRequest(city);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Cannot find city", e);
        }

        return result;
    }

    private Coordinate doRequest(String city) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();

        final HttpRequest request = HttpRequest.newBuilder(
                        URI.create(
                                String.format(
                                        "https://geocode.xyz/%s?json=1",
                                        URLEncoder.encode(city, StandardCharsets.UTF_8)
                                )
                        )
                )
                .header("accept", "application/json")
                .build();

        final var response = client.send(request, new JsonBodyHandler<>(Coordinate.class));

        return response.body().get();
    }
}
