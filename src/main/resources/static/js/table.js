var tbl;
var lastRow = {};
var rowCount = 10;

$( document ).ready(function() {
    tbl = $('#paginatedTable').DataTable({
        'paging': false,
        'order': [[2, "asc"]],
        'info': false,
        'columns': [
            {data: 'actorId'},
            {data: 'firstName'},
            {data: 'lastName'},
            {data: 'lastUpdate'}
        ]
    });
    loadBunchActors();
});

function loadBunchActors() {
    lastRow.rowCount = rowCount;
    $.get('bunchActors', lastRow, function(actors) {
        for (let actor of actors) {
            tbl.row.add(actor);
        }
        tbl.draw();
        lastRow = actors[actors.length - 1];
        document.getElementById('x42').textContent = 'Showing ' + tbl.data().count() + ' entries';
    });
}