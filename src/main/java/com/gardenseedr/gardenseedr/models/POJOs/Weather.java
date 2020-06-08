package com.gardenseedr.gardenseedr.models.POJOs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{

    private String weatherDescription;
    private double currentTemp;
    private double lowTemp;
    private double highTemp;
    private String generalCondition;
    private double humidity;
    private String city;
    private String sunrise;
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(String generalCondition) {
        this.generalCondition = generalCondition;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(double lowTemp) {
        this.lowTemp = lowTemp;
    }

    public double getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(double highTemp) {
        this.highTemp = highTemp;
    }

    @Bean
    public Weather weather() {
        return new Weather();
    }

    public Weather() {
        super();

    }

    public Weather(Weather weather) {

    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherDescription((String) weather.get("description"));
        setGeneralCondition((String) weather.get("main"));
    }

    @JsonProperty("main")
    public void setMain(Map<String, Double> main) {
        setCurrentTemp(main.get("temp"));
        setLowTemp(main.get("temp_min"));
        setHighTemp(main.get("temp_max"));
        setHumidity(main.get("humidity"));
    }

//    @JsonProperty("name")
//    public void setName(Map<String, String> name) {
//        setCity("name");
//    }

    @JsonProperty("sys")
    public void setSys(Map<String, String> sys) {
        setSunrise(sys.get("sunrise"));
        setSunset(sys.get("sunset"));

    }

}
