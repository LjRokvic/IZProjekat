
$(function () {
    var id = getUrlParameter("id");

    $.get({
        url: '/api/patient/' + id,
        success: function (data) {
            setPatient(data);
        }
    });
});




function setPatient(data) {
    $('#name_val').text(data.name + ' ' + data.lastName);
    $('#age_val').text(data.age);
    $('#gender_val').text(data.gender);

    for(val in data.conditions){
        var con = $('<p> - ' + data.conditions[val].name + '</p>');
        $('#history_val').append(con);
    }

}


