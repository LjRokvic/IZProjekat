
$(function () {

    $('#hiddenList').fadeOut(0);
    $('#onlyIfPatient').fadeOut(0);

    $('#evaluate_btn_rule').on('click', function(event) {
        event.preventDefault();

        var syms = $('select#symptoms_select_rule').val();

        $.ajax({
            url: "/api/all",
            type: 'POST',
            data: JSON.stringify(syms),
            contentType: 'application/json',
            success: function (data) {
                var table = $('#ruleResultTable').DataTable();
                table.clear();
                for(val in data) {
                    fillResults(table,data[val]);
                }

            },
            error: function (data) {

            }
        });

    });

    var  id = getUrlParameter("id");
    $.get({
       url: "/api/patient/"+id,
        success:function (data) {

            $('#addPreventList').html('');
            $('#addPreventList').append('<li>None found</li>');
            var ag = data.age === 'M';
            var siz = data.conditions.length > 0;


            $.get({
               url:"/api/allPreventive/"+data.age +'/'+ag+'/'+ siz ,
               success:function (data1) {
                   var t1 = data1.length;
                   if (t1 > 0)
                       $('#addPreventList').html('');
                    for (el in data1){
                        $('#addPreventList').append('<li>'+ data1[el] +'</li>');
                    }


                   $('#onlyIfPatient').fadeIn(250);
               }
            });




        }
    });



    // $('#evaluate_btn_rule_history').on('click', function(event) {
    //     event.preventDefault();
    //     var id = getUrlParameter("id");
    //     var syms = $('select#symptoms_select_rule').val();
    //
    //     $.get({
    //         url:"/api/patient/" + id,
    //         success:function (data) {
    //             $.ajax({
    //                 url: "/cbr/evaluate/case?id="+id,
    //                 type: 'POST',
    //                 data: JSON.stringify({
    //                     age: 25,
    //                     gender: 'M',
    //                     symptoms: syms
    //                 }),
    //                 contentType: 'application/json',
    //                 success: function (data) {
    //                     var table = $('#cbrResultTable').DataTable();
    //                     table.clear();
    //                     for(val in data) {
    //                         fillResults(table,data[val]);
    //                     }
    //
    //                 },
    //                 error: function (data) {
    //
    //                 }
    //             });
    //         }
    //     });



    // });
});

function displayTreatment(event) {
    var cond = localStorage.getItem(event);
    $.get({
       url:'/api/treatment/' + cond,
        success:function (data) {
            $('#addListTreatment').html('');
            for( el in data){
                $('#addListTreatment').append('<li>'+ data[el] +'</li>')
            }
            $('#hiddenList').fadeIn(250);
        }
    });

}

function displayTest(event) {
    var cond = localStorage.getItem(event);
    $.get({
       url:'/api/test/'+ cond,
       success:function (data) {
          if (data != null){
              $('#addListTest').html('');
              for (val in data){
                $('#addListTest').append('<li>'+ data[val] +'</li>')
              }

              $('#hiddenList').fadeIn(250);

          }
       }
    });

}

var iter = 0;

function fillResults(table, data) {


    var tr = $('<tr></tr>');
    //var num = $('<td>' + num + '</td>');
    var prob = $('<td>' + data.prob + '</td>');
    var numSim = $('<td>' + data.num + '</td>');
    var con = $('<td>' + data.condition + '</td>');
    var btnTest = $('<td><button id="'+iter+'RAN" onclick="displayTest(this.id)" type="button" class="btn btn-primary" >' + 'Test' + '</button></td>');
    var btnTreat = $('<td><button id="'+iter+'RAN" onclick="displayTreatment(this.id)" type="button" class="btn btn-primary">' + 'Treatments' + '</button></td>');
    tr.append(con).append(prob).append(numSim).append(btnTest).append(btnTreat);
    table.row.add(tr).draw();
    iter++;
    localStorage.setItem(iter+"RAN", data.condition);

    /*
    $('#' + hash +'TEST').on('click', function (event) {
        event.preventDefault();

        displayTest(event.id.replace('TEST',''));
    });
    $('#'+ hash + 'T').on('click',function (event) {
        event.preventDefault();
        displayTreatment(event.id.replace(''));
    });
    */




}

function closePopup() {
    var t = $("hiddenList").fadeOut(500);
}
