package pt.brunojesus.esg.meteo.exception;

/**
 * Exception to be thrown when unable to find weather information
 */
public class WeatherNotFoundException extends Exception {

    public WeatherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
