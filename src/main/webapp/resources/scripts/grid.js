
$(function() {
    $("#grid > ul > li").click( function(event){
        var id = $(this).attr("id").substring(5);

        $("#info_" + id ).removeClass("hidden");
        $("#overlay").removeClass("hidden");
    });

    $("#grid div.tile.popup a.close").click( function(event) {
        event.preventDefault();
        event.stopImmediatePropagation();
        var parent = $(this).closest(".tile.popup");
        $(parent).addClass("hidden");
        $("#overlay").addClass("hidden");
    });
});