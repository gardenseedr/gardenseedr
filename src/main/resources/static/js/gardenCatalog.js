


function fetchPlants(){
    fetch("https://openfarm.cc/api/v1/crops/550144506665350003000000")
        .then(response => {
            if(!response.ok){
                throw Error("ERROR");
            }
            return response.json();
        })
        .then(data => {
            console.log(data.data);
            var picture = data.data.attributes.main_image_path;
            console.log(picture);
            var info = data.data.attributes;
            var html_var = '<div>';
            html_var += `<img class="card-img-top" id="plant-pic" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('swipe').innerHTML = html_var;
            });
        }


fetchPlants();





