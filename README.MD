# Meteo API
**API for getting weather information**

This library provides an easy way to get the current weather information. The goal of this library is to be as easy to
use as possible.

## Example usage
```java
package pt.brunojesus.esg.meteo;

import pt.brunojesus.esg.meteo.exception.CityNotFoundException;
import pt.brunojesus.esg.meteo.exception.WeatherNotFoundException;
import pt.brunojesus.esg.meteo.weather.model.Weather;

public class Main {

    public static void main(String[] args) throws WeatherNotFoundException, CityNotFoundException {
        System.out.println(
                weatherInformation("Lisbon, PT")
        );
    }

    public static String weatherInformation(String cityName) throws WeatherNotFoundException, CityNotFoundException {
        MeteoAPI meteoAPI = new MeteoAPI();
        final Weather weatherInfo = meteoAPI.fetchWeatherForCity(cityName);

        return String.format("City: %s%nTemperature: %s °C%nWind Speed: %s Km/h%n",
                cityName,
                weatherInfo.getCurrentWeather().getTemperature(),
                weatherInfo.getCurrentWeather().getWindSpeed()
        );
    }
}
```

This will display something like:
```text
City: Lisbon, PT
Temperature: 23.2 °C
Wind Speed: 8 Km/h
```

## Documentation
You can find the updated JavaDoc on the **Releases** page.

## How to import this library

### Using Maven
Add this dependency to your `pom.xml` file

```xml
<dependency>
  <groupId>pt.brunojesus.esg.meteo</groupId>
  <artifactId>meteo</artifactId>
  <version>1.0</version>
</dependency>
```

Since this library is not on Maven Central you will also need to add the following maven repository:
```xml
<repository>
  <id>mvn-brunojesus</id>
  <name>Bruno Jesus MVN Repo</name>
  <url>https://mvn.brunojesus.pt/{repository}</url>
</repository>
```