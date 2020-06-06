$(document).ready(function () {

    $(".garden-square").click(function () {
        $("#api-results").html("");
        $("#modal-title").text("Search Crops");
        var plantSquare = $(this).attr("id");
        console.log(plantSquare);
        $("#square-num").val(plantSquare);
        var plantName = $(this).children().attr('plant-name');
        if (plantName == null) {
            console.log("no plant name");
            $(".plantSearch").show();
        } else {
            $(".plantSearch").hide();
            console.log("Plant Name:" + plantName);
            $("#modal-title").text(plantName);
            var plantBody = null;
            plantBody = $(this).children().attr('plant-body');
            var plantedSquareId = $(this).children().attr('plant-id');
            console.log(plantedSquareId);
            plantBody = '<a href="/square/' + plantedSquareId + '">View More about this plant</a>'
            $("#api-results").html(plantBody);
        }

        // if (plantBody == undefined) {
        //     // var plantSearch = "search";
        //     $(".plantSearch").show();
        //     // $("#modal-body").text(plantSearch);
        // }
    })
    });

