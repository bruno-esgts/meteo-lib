package pt.brunojesus.esg.meteo.weather;

import pt.brunojesus.esg.meteo.exception.WeatherNotFoundException;
import pt.brunojesus.esg.meteo.geo.model.Coordinate;
import pt.brunojesus.esg.meteo.mapping.JsonBodyHandler;
import pt.brunojesus.esg.meteo.weather.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Handles weather information requests
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-05-07
 */
public class WeatherService {

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true";

    /**
     * Fetches the weather for the provided coordinates
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the Weather information for the provided coordinates
     * @throws WeatherNotFoundException when unable to find weather information
     */
    public Weather fetchWeather(final double latitude, final double longitude) throws WeatherNotFoundException {
        final Weather result;

        try {
            result = doRequest(latitude, longitude);
        } catch (IOException | InterruptedException e) {
            throw new WeatherNotFoundException("Cannot fetch weather", e);
        }

        return result;
    }


    private Weather doRequest(final double latitude, final double longitude) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();

        final HttpRequest request = HttpRequest.newBuilder(URI.create(String.format(API_URL, latitude, longitude))).header("accept", "application/json").build();

        final var response = client.send(request, new JsonBodyHandler<>(Weather.class));

        return response.body().get();
    }
}
