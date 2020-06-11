function reportWeather(){
    $.ajax("https:openfarm.cc/api/v1/crops/550144506665350003000000").done(function (crops) {
        console.log(crops);
        console.log(crops.data.attributes.description);
    });
}
reportWeather();
fetch("https:openfarm.cc/api/v1/crops/550144506665350003000000")
    .then(response => response.json())
    .then(result => console.log(result))
    .catch(data => console.log(data));