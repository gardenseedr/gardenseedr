

$(".label").click(function () {
$(this).css("color", "white")
});


$(".garden-square").click(function () {
$(".plantSearch").hide();
    var plantName = null;
    plantName = $(this).children().attr('plant-name');
    $("#modal-title").text(plantName);
    console.log(plantName);
    if (plantName == undefined){
        var plantSearch = "Find a plant to plant";
        $("#modal-title").html(plantSearch);
    }
    var plantBody = null;
    plantBody = $(this).children().attr('plant-body');
    $("#modal-body").text(plantBody);
    if (plantBody == undefined){
        var plantSearch = "search";
        $(".plantSearch").show();
        $("#modal-body").text(plantSearch);

    }

});



// $(".btn").on("click", function () {
//     $(".modal-body").load('content.sql', function () {
//         $("#gardenModal").modal({show:true})
//     });
// });