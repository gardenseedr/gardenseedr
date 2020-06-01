

$(".label").click(function () {
$(this).css("color", "white")
});

// $(".btn").click(function () {
//     var squareIdNum = $(this).val(id);
//     $(".squareId").val(this.id);
//     alert("you clicked "+ this.id)
// });
//
// $(".btn").click(function () {
// $('squareId').val($('.btn option:selected').attr(this.id));
// });

$(".btn").on("click", function () {
    $(".modal-body").load('content.sql', function () {
        $("#gardenModal").modal({show:true})
    });
});