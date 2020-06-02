<!-- ALL THE MAP STUFF -->
//SA Coords
var lat = 29.4252;
var long = -98.4916;


<!-- GETTING AND DISPLAYING SA WEATHER INFO -->
function getWeather(x) {

    for (var i = 0; i < 3; ++i){
        var content = "";

        var weatherIcon;

        var weatherIcon;

        if (data.weather[0].main === "Clear") {
            weatherIcon = '<i class="fas fa-sun fa-3x"></i>';
        }
        else if (data.weather[0].main === "Rain") {
            weatherIcon = '<i class="fas fa-cloud-rain fa-3x"></i>';
        }
        else if (data.weather[0].main === "Snow") {
            weatherIcon = '<i class="far fa-snowflake fa-3x"></i>';
        }
        else if (data.weather[0].main === "Fog" || data.weather[0].main === "Mist" || data.weather[0].main === "Smoke" || data.weather[0].main === "Haze" || data.weather[0].main === "Dust" || data.weather[0].main === "Sand" || data.weather[0].main === "Drizzle") {
            weatherIcon = '<i class="fas fa-smog fa-3x"></i>';
        }
        else if (data.weather[0].main === "Clouds") {
            weatherIcon = '<i class="fas fa-cloud fa-3x"></i>';
        }
        else if (data.weather[0].main === "Ash") {
            weatherIcon = '<i class="fas fa-running fa-3x"></i>';
        }
        else if (data.weather[0].main === "Tornado" || data.weather[0].main === "Squall") {
            weatherIcon = '<i class="fas fa-wind fa-3x"></i>';
        }
        else if (data.weather[0].main === "Thunderstorm") {
            weatherIcon = '<i class="fas fa-poo-storm fa-3x"></i>';
        }

        var date;

        if (i === 0){
            date = (new Date().getMonth() + 1) + "/" + new Date().getDate() + "/" + new Date().getFullYear();
        }
        else if (i === 1){
            date = (new Date().getMonth() + 1) + "/" + (new Date().getDate() + 1) + "/" + new Date().getFullYear();
        }
        else if (i === 2){
            date = (new Date().getMonth() + 1) + "/" + (new Date().getDate() + 2) + "/" + new Date().getFullYear();
        }

        content += (
            "<p>" +
            date +
            "</p>" +
            "<p>" +
            x.daily.data[i].temperatureHigh + "F | " +
            x.daily.data[i].temperatureLow + "F" +
            "</p>" +
            "<p>" +
            "Chance of rain: " +
            (x.daily.data[i].precipProbability * 100)+ "%" +
            "</p>" +
            "<p>" +
            weatherIcon +
            "</p>" +
            "<p>" +
            x.daily.data[i].summary +
            "</p>"
        );

        var TheCorrectDiv = "#day" + i;
        $(TheCorrectDiv).html("").append(content);
    }
}

function reportWeather(la, lo){
    $.ajax("https://api.openweathermap.org/data/2.5/forecast/daily?zip=" + zipcode + "&appid=" + OpenWeatherToken + "&units=imperial").done(function (data) {
    });
    // $(".subheader").html("The weather in: " + markerLocation);
}




$(document).ready(function () {

    $(".square").click(function(){
        alert("paaoi");/* REPLACE THIS WITH YOUR OWN CODE */
    });});