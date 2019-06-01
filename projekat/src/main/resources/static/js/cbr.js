$(function() {

    var id = getUrlParameter("id");


 $('#evaluate_btn').on('click', function(event) {
        event.preventDefault();

        var syms = $('select#symptoms_select').val();

        $.ajax({
            url: "/cbr/evaluate/case?id="+id,
            type: 'POST',
            data: JSON.stringify({
            	age: 25,
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

 $('#preventive_eval_btn').on('click', function(event) {
        event.preventDefault();

        var history = $('select#family_conditions_select').val();
        var riskFactor = $('select#risk_factor_select').val();

        $.ajax({
            url: "/cbr/evaluate/preventive?id="+id,
            type: 'POST',
            data: JSON.stringify({
            	age: 10,
                gender: 'M',
                pastConditions: [],
                familyHistory: history,
                otherRiskFactors: riskFactor
            }),
            contentType: 'application/json',
            success: function (data) {
            	var ptable = $('#cbrPreventiveTable').DataTable();
            	ptable.clear();
            	for(val in data) {
            		fillResultsPreventive(ptable,data[val]);
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

  $('#preventive_add_btn').on('click', function(event) {
        event.preventDefault();

        var fc = $('select#family_conditions_select').val();
        var rf = $('select#risk_factor_select').val();
        var tst = $('select#preventive_tests_select').val();

        $.ajax({
            url: "/cbr/evaluate/addPreventive?id="+id,
            type: 'POST',
            data: JSON.stringify({
            	age: 15,
            	gender: 'M',
                familyHistory: fc,
                otherRiskFactors: rf,
                recommendedPreventiveTests: tst

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
        url: '/api/patient/'+id,
        success: function (data) {
        	setPatient(data);
        }
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
        $('#preventive_tests_select').fSelect();
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
        	$('#family_conditions_select').fSelect();
        	$('#risk_factor_select').fSelect();
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

	function fillResultsPreventive(table, data) {

	    var tr = $('<tr></tr>');
	    var num = $('<td>' + data.number + '</td>');
	    var sim = $('<td>' + data.similarity + '</td>');
	    var tst = $('<td>' + data.preventiveTests + '</td>');
	    tr.append(num).append(sim).append(tst);
	    table.row.add(tr).draw();
	}

	function addSymptoms(data) {
	    var sym = $('<option value="' + data + '">' + data + '</option>');
		$('#symptoms_grp').append(sym);
	}
	function addTests(data) {
	    var tes = $('<option value="' + data + '">' + data + '</option>');
	    var tes1 = $('<option value="' + data + '">' + data + '</option>');
		$('#tests_grp').append(tes);
		$('#pt_grp').append(tes1);
	}
	function addTreatments(data) {
	    var tre = $('<option value="' + data + '">' + data + '</option>');
		$('#treatments_grp').append(tre);
	}
	function addDiagnosi(data) {
	    var dia = $('<option value="' + data + '">' + data + '</option>');
	    var dia1 = $('<option value="' + data + '">' + data + '</option>');
		$('#diagnosis_grp').append(dia);
		$('#fc_grp').append(dia1);
	}
	function setPatient(data) {
		$('#name_val').text(data.name + ' ' + data.lastName);
		$('#age_val').text(data.age);
		$('#gender_val').text(data.gender);

		for(val in data.conditions){
			var con = $('<p> - ' + data.conditions[val].name + '</p>');
			$('#history_val').append(con);
		}

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