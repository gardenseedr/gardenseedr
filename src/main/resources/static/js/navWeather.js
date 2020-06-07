//
// //zipcode for new openweather api
// //hardcoded for now will need to change later
// var zipcode = 78215,us;
//
// <!-- GETTING AND DISPLAYING SA WEATHER INFO -->
// function getOpenWeather(data) {
//
//         var weatherIcon;
//
//         if (data.weather[0].main === "Clear") {
//             weatherIcon = '<i class="fas fa-sun fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Rain") {
//             weatherIcon = '<i class="fas fa-cloud-rain fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Snow") {
//             weatherIcon = '<i class="far fa-snowflake fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Fog" || data.weather[0].main === "Mist" || data.weather[0].main === "Smoke" || data.weather[0].main === "Haze" || data.weather[0].main === "Dust" || data.weather[0].main === "Sand" || data.weather[0].main === "Drizzle") {
//             weatherIcon = '<i class="fas fa-smog fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Clouds") {
//             weatherIcon = '<i class="fas fa-cloud fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Ash") {
//             weatherIcon = '<i class="fas fa-running fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Tornado" || data.weather[0].main === "Squall") {
//             weatherIcon = '<i class="fas fa-wind fa-3x"></i>';
//         }
//         else if (data.weather[0].main === "Thunderstorm") {
//             weatherIcon = '<i class="fas fa-poo-storm fa-3x"></i>';
//         }
//
//         var content = weatherIcon;
//
//         $("#icon").append(content);
//
//     console.log(data.weather[0].main);
//     console.log(data);
//
// }
//
//
//
// function reportWeather(){
//     $.ajax("https://api.openweathermap.org/data/2.5/weather?zip=" + zipcode + "&appid=" + OpenWeatherToken + "&units=imperial").done(function (data) {
//         getOpenWeather(data);
//
//         // var currentTemp = (data.main.temp - 273.15) * 1.8 + 32;
//         // console.log(temp.toFixed(0));
//     });
//
// }
//
// reportWeather();

