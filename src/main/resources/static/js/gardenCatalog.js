


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
            html_var += `<img class="card-img-top" id="arugula" src="${picture}" alt="Card image cap"`;
            html_var += '<p>' + info.name + '</p>';
            html_var += '<p>' + info.binomial_name + '</p>';
            html_var += '<p>' + info.description + '</p>';
            html_var += '</div>';
            console.log(info.description);
            console.log(html_var);
            document.getElementById('swipe').innerHTML = html_var;
            });
}

function fetchApiId(){
    fetch("https://openfarm.cc//api/v1/users/5ed9760c9364840004d3872f/gardens/")
        .then(response => {
            if(!response.ok){
                throw Error("ERROR");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            console.log(data.data[0].relationships.garden_crops.data);
        })
}

function practiceCall() {
    const options = {
        method: "POST",
        "data": {
            "email": "jaque3985@gmail",
            "password": "jack3985"
        }
    };
    fetch("https://openfarm.cc//api/v1/gardens/5ed979ed9364840004d38733/")
        .then(response => {
            if(!response.ok){
                throw Error("ERROR");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
        })

}

// practiceCall();
//
// fetchApiId();


fetchPlants();

// function brancsCrazyIdea() {
//     const options = {
//         method: "GET",
//         "data": {
//             "email": "jaque3985@gmail",
//             "password": "jack3985"
//         }
//     };
//     fetch('https://openfarm.cc//api/v1/token/', options)
//         .then(response => {
//             if(!response.ok){
//                 throw Error("ERROR");
//             }
//             return response.json();
//         })
//         .then(data => {
//             console.log(data);
//         })
// }
//
// brancsCrazyIdea();

function ajaxcall() {
    const options = {
        method: "POST",
        data: {
            email: "jaque3985@gmail",
            password: "jack3985"
        }
    };
    $.ajax("https://openfarm.cc//api/v1/token/").done(function (data) {
        console.log(data);
    }).fail(function (param, thing, hello) {
        console.log(param);
        console.log(thing);
        console.log(hello);
    })
}

// ajaxcall();



