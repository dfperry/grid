
$(function() {

    selected = false;
    selectedId = "";

    $(document).on("click", "#grid > ul > li.source, #grid > ul > li.dest", function(event){
        event.preventDefault();
        event.stopImmediatePropagation();
        var id = $(this).attr("id").substring(5);

        jAlert("Source: " + selectedId + "\nDestination: " + id, "Ship Deployment", function(){});
        //alert("Source: " + selectedId + "\nDestination: " + id );
        clearSourceDest();
    });

    $("#grid > ul > li").click( function(event){
        var id = $(this).attr("id").substring(5);
        if( !selected ) {
            var safety = $("#safety_" + id ).val();
            $("#overlay").removeClass("hidden");

            $("#info_" + id ).show();
            $("#info_" + id ).removeClass("hidden");


            $("#popup").removeClass("SAFE");
            $("#popup").removeClass("HAZARDOUS");
            $("#popup").addClass(safety);
        }
        else {
            if( !$(this).hasClass("dest") ) {
                alert("Canceling");
                clearSourceDest();
            }
        }

    });

    $("#grid div.tile.popup a.close").click( function(event) {
        event.preventDefault();
        event.stopImmediatePropagation();
        var parent = $(this).closest(".tile.popup");
        $(parent).addClass("hidden");
        $("#overlay").addClass("hidden");
    });

    $("#grid div.tile.popup a.adjacent").click( function(event) {
        event.preventDefault();
        event.stopImmediatePropagation();
        var parent = $(this).closest(".tile.popup");
        var id = $(parent).attr("id").substring(5);

        selected = true;
        selectedId = id;

        var range = $(this).attr("title");
        var adjacentCells = [];
        $(parent).addClass("hidden");
        $("#overlay").addClass("hidden");

        $.ajax({
            url: id + "/adjacent/" + range,
            success: function(data) {
                $(data).each(function() {
                    $("#cell_" + this).addClass("dest");
                });
                $("#cell_" + id).removeClass("dest").addClass("source");
            }
        });
    });
});

function clearSourceDest() {

    selected = false;
    selectedId = "";

    $("#grid > ul > li.dest").removeClass("dest");
    $("#grid > ul > li.source").removeClass("source");
}