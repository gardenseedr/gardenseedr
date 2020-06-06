$(document).ready(function () {

    $(".garden-square").click(function () {
        var plantSquare = $(this).attr("id");
        console.log(plantSquare);
        $("#square-num").val(plantSquare);
        $(".plantSearch").hide();
        var plantName = null;
        plantName = $(this).children().attr('plant-name');
        $("#modal-title").text(plantName);
        var plantBody = null;
        plantBody = $(this).children().attr('plant-body');
        $("#modal-body").text(plantBody);
        if (plantBody == undefined) {
            var plantSearch = "search";
            $(".plantSearch").show();
            $("#modal-body").text(plantSearch);
        }
    });


    let spanArray = [];
    spanArray = $(".plantData");
    for (var i = 0; i < spanArray.length; i++) {
        console.log($(spanArray[i].attributes[3]));
        //span array at index code
        // $(spanArray[i]).parent().css("background-color", "green");

        if ($(spanArray[i].attributes[3].value) >= 15) {
            $(spanArray[i]).parent().css("background", "red");
        }
        if ($(spanArray[i].attributes[3].value) >= 10) {
            $(spanArray[i]).parent().css("background", "orange");
        }
        if ($(spanArray[i].attributes[3].value) >= 5) {
            $(spanArray[i]).parent().css("background", "yellow");
        }
        if ($(spanArray[i].attributes[3].value) >= 3) {
            $(spanArray[i]).parent().css("background", "green");
        }
        if ($(spanArray[i].attributes[3].value) < 3) {
            $(spanArray[i]).parent().css("background", "blue");
        }
    }

});