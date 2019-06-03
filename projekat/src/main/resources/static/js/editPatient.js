$(function () {


    // $('#submitButton').html("Update");


    getConditions();



    var id = getUrlParameter('id');
    if (id !== undefined){

        setTimeout(function () {
            $.get({
                url: '/api/patient/'+ id,
                success: function (data) {
                    if (data!= null){
                        fillData(data);
                    }
                }
            });
        }, 100);

        
    }
    $('#addForm').on('submit', function (e) {
        event.preventDefault();

        var name = $("input[name='name']").val();
        var lastName = $("input[name='lastName']").val();

        var gender = $("input[name='gender']").val().toUpperCase();
        var age = $("input[name='age']").val();

        var fc = $('select#condition_select').val();

        if (id === undefined){
            // Add new
            $.ajax({
                url: "/api/patient",
                type: 'POST',
                data: JSON.stringify({
                    id : -1,
                    name: name,
                    lastName : lastName,
                    gender: gender,
                    age: age,
                    conditions: fc
                }),
                contentType: 'application/json',
                success: function (data) {
                    location.replace("profile.html?id="+ data.id);
                },
                error: function (data) {

                }
            });

        } else {

            $.ajax({
                url: "/api/patient",
                type: 'PUT',
                data: JSON.stringify({
                    id : id,
                    name: name,
                    lastName : lastName,
                    gender: gender,
                    age: age,
                    conditions: fc
                }),
                contentType: 'application/json',
                success: function (data) {
                    location.replace("profile.html?id=" + data.id);
                },
                error: function (data) {

                }
            });

        }



    });






});

function fillData(data) {

    $( "input[name='id']" ).val(data.id); // idrentacar-a
    $( "input[name='name']" ).val(data.name);
    $( "input[name='lastName']" ).val(data.lastName);
    $( "input[name='gender']" ).val(data.gender);
    $( "input[name='age']" ).val(data.age);

    var st = "";
    var con = data.conditions;
    for (var val in con){
        var q = con[val];
        st = st + q.name + ", ";

        $(".fs-option[data-value='"+q.name+"']").addClass("selected");

    }
    st = st.slice(0,st.length-2);


    $(".fs-label").text(st);


}
function addCon(data) {
    var tre = $('<option value="' + data + '">' + data + '</option>');
    $('#condition_grp').append(tre);
}

function getConditions() {

    $.get({
        url: '/api/condition',
        success: function (data) {
            var a = 0;
            for(val in data) {
                a++;
                addCon(data[val]);
            }
            if (a === 0){
                setTimeout(function(){
                    getConditions();
                }, 50);
            }else {
                $('#condition_select').fSelect();
            }

        }
    });

}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1].replace(/\+/g, ' '));
        }
    }
};
