$(document).ready(function () {
    //figure out how to use later
    // $("#closeButton").click(function () {
    //     $("#txtSearch").text("");
    // });

    $(".garden-square").click(function () {
        $("#api-results").html("");
        $("#modal-title").text("Search Crops");
        var plantSquare = $(this).attr("id");
        console.log(plantSquare);
        $("#square-num").val(plantSquare);
        var plantName = $(this).children().attr('plant-name');
        var apiId = $(this).children().attr('plant-body');
        console.log(apiId);
        if (plantName == null) {
            console.log("no plant name");
            $(".plantSearch").show();
            $("#submit-crop").show();
        } else {
            $("#submit-crop").hide();
            $(".plantSearch").hide();
            console.log("Plant Name:" + plantName);
            $("#modal-title").text(plantName);

            // plantBody = $(this).children().attr('plant-body');
            var plantedSquareId = $(this).children().attr('plant-id');
            console.log(plantedSquareId);
            var plantUrl = "https://openfarm.cc/api/v1/crops/" + apiId;
            fetch(plantUrl)
                .then(response => response.json())
                .then(data => {
                    var plantBody = "";
                    var crop = data.data.attributes;
                    plantBody += "<p><strong>Sun Requirements: </strong>" + crop.sun_requirements + "</p>";
                    plantBody += "<p><strong>Sowing Method: </strong>" + crop.sowing_method + "</p>";
                    plantBody += "<p><strong>Spread: </strong>" + (((crop.spread) / 2.54).toFixed(0)) + " inches</p>";
                    plantBody += "<p><strong>Row Spacing: </strong>" + (((crop.row_spacing) / 2.54).toFixed(0)) + " inches</p>";
                    plantBody += "<p><strong>Height: </strong>" + (((crop.height) / 2.54).toFixed(0)) + " inches</p>";
                    plantBody += '<a href="/square/' + plantedSquareId + '">See more about your ' + plantName.toLowerCase() + '</a>';
                    $("#api-results").html(plantBody);
                    console.log(crop);});

        }


        // if (plantBody == undefined) {
        //     // var plantSearch = "search";
        //     $(".plantSearch").show();
        //     // $("#modal-body").text(plantSearch);
        // }
    })

    });

