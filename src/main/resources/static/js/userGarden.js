
$( document ).ready(function() {


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



    // /*<![CDATA[*/
    // var plant = /*[[${allThePlants}]]*/ 'plant';
    // /*]]>*/
    //
    // $('#txtSearch').on('keyup', function () {
    //     var value = $(this).val();
    //     var filteredData = filterFunction(value, plant);
    //
    //     rebuildTable(filteredData);
    // });
    //
    // function filterFunction(value, data) {
    //     var filteredData = [];
    //     for (var i = 0; i < data.length; i++) {
    //         var plant = data[i].toLowerCase();
    //         if (plant.includes(value)) {
    //             filteredData.push(data[i])
    //         }
    //     }
    //     return filteredData;
    // }
    //
    // function rebuildTable(data) {
    //     console.log(data);
    //     var table = document.getElementById('plantTable');
    //     var html = '<div class="modal-body">';
    //     data.forEach(function (plantName) {
    //         html +=
    //             '<span>' +
    //             plantName +
    //             '</span>';
    //     });
    //     table.innerHTML = html;
    // }
});
