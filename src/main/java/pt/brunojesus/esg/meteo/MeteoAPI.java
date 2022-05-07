package pt.brunojesus.esg.meteo;

import pt.brunojesus.esg.meteo.exception.CityNotFoundException;
import pt.brunojesus.esg.meteo.exception.WeatherNotFoundException;
import pt.brunojesus.esg.meteo.geo.GeoService;
import pt.brunojesus.esg.meteo.geo.model.Coordinate;
import pt.brunojesus.esg.meteo.weather.WeatherService;
import pt.brunojesus.esg.meteo.weather.model.Weather;

/**
 * Library's facade, exposes all important features of the library.
 *
 * @author Bruno Jesus
 * @since 2022-05-07
 * @version 1.0
 */
public class MeteoAPI {

    private final WeatherService weatherService;
    private final GeoService geoService;

    public MeteoAPI() {
        this.weatherService = new WeatherService();
        this.geoService = new GeoService();
    }

    /**
     * Finds the coordinates for a given city
     *
     * @param cityName the name of the city to search for
     * @return the city {@link Coordinate}
     * @throws CityNotFoundException if we cannot find the city
     */
    public Coordinate findCityCoordinates(final String cityName) throws CityNotFoundException {
        return geoService.fetchCoordinates(cityName);
    }

    /**
     * Fetch the weather information for the provided latitude and longitude
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the weather information
     * @throws WeatherNotFoundException if we cannot find weather information
     */
    public Weather fetchWeatherForCoordinates(final double latitude, final double longitude) throws WeatherNotFoundException {
        return weatherService.fetchWeather(latitude, longitude);
    }

    /**
     * Fetches the weather for the provided {@link Coordinate}
     *
     * @param coordinate the {@link Coordinate} containing the latitude and longitude
     * @return the Weather information for the provided coordinates
     * @throws WeatherNotFoundException when unable to find weather information
     */
    public Weather fetchWeatherForCoordinates(final Coordinate coordinate) throws WeatherNotFoundException {
        return fetchWeatherForCoordinates(coordinate.getLatitude(), coordinate.getLongitude());
    }

    /**
     * Fetch weather for the provided city name
     * Searches for the city coordinates and fetches the weather information.
     * Combines the {@link #findCityCoordinates(String)} and the {@link #fetchWeatherForCoordinates(Coordinate)} methods.
     *
     * @param cityName the name of the city to search for
     * @return the weather information
     * @throws CityNotFoundException when unable to find the city
     * @throws WeatherNotFoundException when unable to find weather information
     */
    public Weather fetchWeatherForCity(final String cityName) throws CityNotFoundException, WeatherNotFoundException {
        final Coordinate coordinate = findCityCoordinates(cityName);
        return fetchWeatherForCoordinates(coordinate);
    }
}
