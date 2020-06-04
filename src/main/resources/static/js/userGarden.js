$(document).ready(function () {

    $(".subheader").css("background", "blue");


    $(".label").click(function () {
        $(this).css("color", "white")
    });

    function convertDate(str) {
        var parts = str.split("-");
        return new Date(parts[1] + "/" + parts[2] + "/" + parts[0]);
    }

    let lastWatered = $(this).children().attr('plant-lastWatered');
    let lastWateredConv = convertDate(lastWatered);
    let today = $(this).children().attr('plant-today');
    let todayDateConv = convertDate(today);
    let dateMath = Math.floor((todayDateConv - lastWateredConv) / (24 * 3600 * 1000));

    if (dateMath < 1) {
        $(".garden-square").css("background", "blue");
    }
    if (dateMath < 3) {
        $(".garden-square").css("background", "green");
    }
    if (dateMath > 5) {
        $(".garden-square").css("background", "yellow");
    }
    if (dateMath > 10) {
        $(".garden-square").css("background", "orange");
    }
    if (dateMath > 15) {
        $(".garden-square").css("background", "red");
    }


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

});
// .text("We are well watered!")
// .text("We're getting thirsty! It's been " + dateMath + " days")
// .text("Don't forget to water us! It's been " + dateMath + " days")
// .text("Help! We Need Water! It's been " + dateMath + " days")
// .text("Oh no! Did you forget us? It's been " + dateMath + " days")