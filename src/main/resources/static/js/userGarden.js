
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
// var plant = /*[[${allThePlants}]]*/;
// /*]]>*/

// $('#txtSearch').on('keyup', function () {
//     var value = $(this).val();
//
//     console.log("plant = " + plant);
//     var data = filterFunction(value, plant);
//
//     rebuildTable(data);
// });
//
// function filterFunction(value, data) {
//     var filteredData = [];
//     for (var i = 0; i<data.length; i++){
//         var plant = data[i].toLowerCase();
//
//         if (plant.includes(value)){
//             filteredData.push(data[i])
//         }
//     }
//     console.log("filtered data " + filteredData);
//     return filteredData;
// }
//
// function rebuildTable(data) {
//     var table = document.getElementById('plantTable');
//     console.log("table " + table);
//     // table.innerHTML='';
//     // for (var i = 0; i <data.length; i++){
//     //     var row = <span>
//     //             ${data[i]}
//     //         </span>;
//     //     table.innerHTML += row
//     // }
// }
});
