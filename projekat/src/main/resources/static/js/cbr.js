$(function() {

    var id = getUrlParameter("id");


 $('#evaluate_btn').on('click', function(event) {
        event.preventDefault();

        var syms = $('select#symptoms_select').val();

        $.ajax({
            url: "/cbr/evaluate/case",
            type: 'POST',
            data: JSON.stringify({
                age: 10,
                gender: 'M',
                symptoms: syms
            }),
            contentType: 'application/json',
            success: function (data) {
            	var table = $('#cbrResultTable').DataTable();
            	table.clear();
            	for(val in data) {
            		fillResults(table,data[val]);
            	}

            },
            error: function (data) {

            },
        });

    });


  $('#make_dia').on('click', function(event) {
        event.preventDefault();

        var syms = $('select#symptoms_select').val();
        var tests = $('select#tests_select').val();
        var dia = $('select#diagnosis_select').val();
        var treats = $('select#treatments_select').val();

        $.ajax({
            url: "/cbr/evaluate/add?id="+id,
            type: 'POST',
            data: JSON.stringify({
                age: 10,
                gender: 'M',
                symptoms: syms,
                tests: tests,
                condition: dia,
                treatments: treats

            }),
            contentType: 'application/json',
            success: function (data) {
				location.reload();
            },
            error: function (data) {

            },
        });

    });



     $.get({
        url: '/api/symptom',
        success: function (data) {
        	for(val in data) {
        		addSymptoms(data[val]);
        	}
        	$('#symptoms_select').fSelect();
        }
    });
    sleep(150);
	 $.get({
        url: '/api/test',
        success: function (data) {
        	for(val in data) {
        		addTests(data[val]);
        	}
        $('#tests_select').fSelect();
        }
    });
	sleep(150);
     $.get({
        url: '/api/treatment',
        success: function (data) {
        	for(val in data) {
        		addTreatments(data[val]);
        	}
           $('#treatments_select').fSelect();
        }
    });
	sleep(150);
     $.get({
        url: '/api/condition',
        success: function (data) {
        	for(val in data) {
        		addDiagnosi(data[val]);
        	}
        }
    });


});

	function fillResults(table, data) {

	    var tr = $('<tr></tr>');
	    var num = $('<td>' + data.number + '</td>');
	    var sim = $('<td>' + data.similarity + '</td>');
	    var tst = $('<td>' + data.tests + '</td>');
	    var dia = $('<td>' + data.diagnosis + '</td>');
	    var tre = $('<td>' + data.treatments + '</td>');
	    tr.append(num).append(sim).append(tst).append(dia).append(tre);
	    table.row.add(tr).draw();
	}

	function addSymptoms(data) {
	    var sym = $('<option value="' + data + '">' + data + '</option>');
		$('#symptoms_grp').append(sym);
	}
	function addTests(data) {
	    var tes = $('<option value="' + data + '">' + data + '</option>');
		$('#tests_grp').append(tes);
	}
	function addTreatments(data) {
	    var tre = $('<option value="' + data + '">' + data + '</option>');
		$('#treatments_grp').append(tre);
	}
	function addDiagnosi(data) {
	    var dia = $('<option value="' + data + '">' + data + '</option>');
		$('#diagnosis_grp').append(dia);
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

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}