
$("#btnNewBooking").click(function () {

    $("#myModal").css({"display": "block"});
    $("#myModal").show("drop", 1000);

});

function callback_new_booking() {
    $("#myModal").css({"display": "none"});
}

$("#close-new-booking").click(function () {
    $("#myModal").hide("drop", 1000 , callback_new_booking());
});
$("#exit-new-booking").click(function () {
    $("#myModal").hide("drop", 1000 , callback_new_booking());
});

