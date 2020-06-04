$(document).ready(function () {

    $(".label").click(function () {
        $(".plantData").css("background", "white")
    });


    $(".garden-square").click(function () {
        $(".plantSearch").hide();
        var plantName = null;
        plantName = $(this).children().attr('plant-name');
        $("#modal-title").text(plantName);
        console.log(plantName);
        if (plantName == undefined) {
            var plantSearch = "Find a plant to plant";
            $("#modal-title").html(plantSearch);
        }
        var plantBody = null;
        plantBody = $(this).children().attr('plant-body');
        $("#modal-body").text(plantBody);
        if (plantBody == undefined) {
            var plantSearch = "search";
            $(".plantSearch").show();
            $("#modal-body").text(plantSearch);

        }
    });






    let lastWatered = null;
    lastWatered = $(".plantData").attr('plant-lastWatered');
    console.log(lastWatered);
    let lastWateredConv = convertDate(lastWatered);
    let today = $(".plantData").attr('plant-today');
    let todayDateConv = convertDate(today);

    let dateMath = Math.floor((todayDateConv - lastWateredConv) / (24 * 3600 * 1000));

    if (lastWatered == null) {
        $(".innerBox").hide();
    } else {
        if(dateMath > 15) {
            $(".plantData").css("background", "red");
            console.log("red? " + dateMath);
        }
        else if (dateMath < 10) {
            $(".plantData").css("background", "orange");
            console.log("orange? " + dateMath);
        }
        else if (dateMath < 5) {
            $(".plantData").css("background", "yellow");
            console.log("yellow? " + dateMath);
        }
        else if (dateMath < 3) {
            $(".plantData").css("background", "green");
            console.log("green? " + dateMath);
        }
        else {
            $(".plantData").css("background", "blue");
            console.log("blue? " + dateMath);
        }

    }

    function convertDate(str) {
        var parts = str.split("-");
        return new Date(parts[1] + "/" + parts[2] + "/" + parts[0]);
    }

})
;






// .text("We are well watered!")
// .text("We're getting thirsty! It's been " + dateMath + " days")
// .text("Don't forget to water us! It's been " + dateMath + " days")
// .text("Help! We Need Water! It's been " + dateMath + " days")
// .text("Oh no! Did you forget us? It's been " + dateMath + " days")