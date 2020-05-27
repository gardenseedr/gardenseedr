<!-- ALL THE MAP STUFF -->
//SA Coords
var lat = 29.4252;
var long = -98.4916;


<!-- GETTING AND DISPLAYING SA WEATHER INFO -->
function getWeather(x) {

    for (var i = 0; i < 3; ++i){
        var content = "";

        var weatherIcon;

        if (x.daily.data[i].icon === "clear-day") {
            weatherIcon = '<i class="fas fa-sun fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "clear-night") {
            weatherIcon = '<i class="fas fa-moon fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "rain") {
            weatherIcon = '<i class="fas fa-cloud-rain fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "snow") {
            weatherIcon = '<i class="far fa-snowflake fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "sleet") {
            weatherIcon = '<i class="fas fa-cloud-rain fa-3x"></i><i class="fas fa-temperature-low"></i>';
        }
        else if (x.daily.data[i].icon === "wind") {
            weatherIcon = '<i class="fas fa-wind fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "fog") {
            weatherIcon = '<i class="fas fa-smog fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "cloudy") {
            weatherIcon = '<i class="fas fa-cloud fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "partly-cloudy-day") {
            weatherIcon = '<i class="fas fa-cloud-sun fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "partly-cloudy-night") {
            weatherIcon = '<i class="fas fa-cloud-moon fa-3x"></i>';
        }
        else if (x.daily.data[i].icon === "hail") {
            weatherIcon = '<i class="fas fa-cloud-meatball fa-3x"></i><i class="fas fa-temperature-low"></i>';
        }
        else if (x.daily.data[i].icon === "thunderstorm") {
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
    $.ajax("https://cors-anywhere.herokuapp.com/https://api.darksky.net/forecast/" + DarkSkyToken + "/" + la + "," + lo).done(function (data) {
        getWeather(data)
    });
    // $(".subheader").html("The weather in: " + markerLocation);
}

reportWeather(lat, long);