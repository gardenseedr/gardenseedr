


function fetchArugula(){
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
            html_var += `<img class="card-img-top" id="arugula" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('1').innerHTML = html_var;
            });
}

fetchArugula();

function fetchAsparagus(){
    fetch("https://openfarm.cc/api/v1/crops/54afdda33166630002400600")
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
            html_var += `<img class="card-img-top" id="asparagus" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('2').innerHTML = html_var;
        });
}

fetchAsparagus();

function fetchBasil(){
    fetch("https://openfarm.cc/api/v1/crops/543c216c3938620002020000")
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
            html_var += `<img class="card-img-top" id="basil" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('3').innerHTML = html_var;
        });
}

fetchBasil();


function fetchBellPepper(){
    fetch("https://openfarm.cc/api/v1/crops/59b0a4ac4dd0a1000400003b")
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
            html_var += `<img class="card-img-top" id="bellPepper" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('4').innerHTML = html_var;
        });
}

fetchBellPepper();


function fetchBroccoli(){
    fetch("https://openfarm.cc/api/v1/crops/54afdefe3166630002990900")
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
            html_var += `<img class="card-img-top" id="broccoli" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('5').innerHTML = html_var;
        });
}

fetchBroccoli();


function fetchBrusselsSprout(){
    fetch("https://openfarm.cc/api/v1/crops/54afdf033166630002ae0900")
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
            html_var += `<img class="card-img-top" id="brusselsSprout" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('6').innerHTML = html_var;
        });
}

fetchBrusselsSprout();


function fetchCabbage(){
    fetch("https://openfarm.cc/api/v1/crops/542e9dce63313600020f1300")
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
            html_var += `<img class="card-img-top" id="cabbage" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('7').innerHTML = html_var;
        });
}

fetchCabbage();


function fetchCarrot(){
    fetch("https://openfarm.cc/api/v1/crops/551ddaf53938340003580000")
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
            html_var += `<img class="card-img-top" id="carrot" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('8').innerHTML = html_var;
        });
}

fetchCarrot();


function fetchCelery(){
    fetch("https://openfarm.cc/api/v1/crops/54afdd0531666300022a0400")
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
            html_var += `<img class="card-img-top" id="celery" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('9').innerHTML = html_var;
        });
}

fetchCelery();

function fetchChives(){
    fetch("https://openfarm.cc/api/v1/crops/54afe3793166630002951100")
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
            html_var += `<img class="card-img-top" id="chives" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('10').innerHTML = html_var;
        });
}

fetchChives();






