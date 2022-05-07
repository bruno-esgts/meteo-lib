package pt.brunojesus.esg.meteo.exception;

/**
 * Exception to be thrown when a city cannot be found
 *
 * @author Bruno Jesus
 * @since 2022-05-07
 * @version 1.0
 */
public class CityNotFoundException extends Exception {

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
