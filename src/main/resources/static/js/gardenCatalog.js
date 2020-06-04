

function fetchPlants(){
    fetch("https://openfarm.cc/api/v1/crops/550144506665350003000000")
        .then(response => response.json())
        .then(data => {
            console.log(data.data.attributes);

    var crop = data.data.attributes;
    console.log(crop);

    var html = '<div>';
    html += '<p>' + crop.name + '</p>';
    html += '<p> Binomial Name: ' + crop.binomial_name + '</p>';
    html += '<p> Description: ' + crop.description + '</p>';
    html += '<p> Sun Requirements: ' + crop.sun_requirements + '</p>';
    html += '</div>';
})
        }

fetchPlants();





