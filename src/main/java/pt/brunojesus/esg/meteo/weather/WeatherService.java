package pt.brunojesus.esg.meteo.weather;

import pt.brunojesus.esg.meteo.mapping.JsonBodyHandler;
import pt.brunojesus.esg.meteo.weather.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class WeatherService {

    public Weather fetchWeather(double latitude, double longitude) {
        final Weather result;

        try {
            result = doRequest(latitude, longitude);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Cannot fetch weather", e);
        }

        return result;
    }

    private Weather doRequest(double latitude, double longitude) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();

        final HttpRequest request = HttpRequest.newBuilder(
                        URI.create(
                                String.format(
                                        "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true",
                                        latitude,
                                        longitude
                                )
                        )
                )
                .header("accept", "application/json")
                .build();

        final var response = client.send(request, new JsonBodyHandler<>(Weather.class));

        return response.body().get();
    }
}
