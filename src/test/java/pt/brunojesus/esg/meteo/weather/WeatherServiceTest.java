package pt.brunojesus.esg.meteo.weather;

import pt.brunojesus.esg.meteo.weather.model.Weather;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @org.junit.jupiter.api.Test
    void fetchWeather() {
       final Weather weather = new WeatherService().fetchWeather(39.34, -9.32);

       assertNotNull(weather);
    }
}