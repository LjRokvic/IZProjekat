

$(function () {


    $.get({
        url : '/api/patient',
        success : function(data) {

            if (data != null) {
                for ( var us in data) {
                    fillUsers(data[us]);
                }

            }
        }
    });

});

function fillUsers(data) {
    var table = $('#friendsTable').DataTable();

    var tr = $('<tr id="'+data.id+'"></tr>');
    var firstN = $('<td>' + data.name + '</td>');
    var lastN = $('<td>' + data.lastName + '</td>');
    var profileBtn = $('<td>' + '<a href="profile.html?id='+ data.id +'"><button type="button" style="display: block;margin:auto;horizontal-align: middle;" class="btn btn-info" name = "'+ data.id + '"style="display:block">Activate</button></a>' + '</td>');
    var editBtn = $('<td>' + '<a href="patient.html?id='+ data.id +'"><button type="button" style="display: block;margin:auto;horizontal-align: middle;" class="btn btn-info" name = "'+ data.id + '"style="display:block">Edit</button></a>' + '</td>');
    tr.append(firstN).append(lastN).append(profileBtn).append(editBtn);
    table.row.add(tr).draw();

}

