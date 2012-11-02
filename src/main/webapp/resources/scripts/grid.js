
$(function() {
    $("#grid > ul > li").click( function(event){
        var id = $(this).attr("id").substring(5);

        var safety = $("#safety_" + id ).val();
        $("#overlay").removeClass("hidden");

        $("#info_" + id ).show();
        $("#info_" + id ).removeClass("hidden");


        $("#popup").removeClass("SAFE");
        $("#popup").removeClass("HAZARDOUS");
        $("#popup").addClass(safety);

    });

    $("#grid div.tile.popup a.close").click( function(event) {
        event.preventDefault();
        event.stopImmediatePropagation();
        var parent = $(this).closest(".tile.popup");
        $(parent).addClass("hidden");
        $("#overlay").addClass("hidden");
    });
});