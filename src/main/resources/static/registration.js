
$( document ).ready(function() {

	// SUBMIT FORM
	$("#submit").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});


	function ajaxPost(){

		// PREPARE FORM DATA
		var formData = {
				userId : $("#userId").val(),
				fName : $("#fName").val(),
				mName :  $("#mName").val(),
				lName :  $("#lName").val(),
				addr :  $("#addr").val(),
				contactNumber :  $("#contactNumber").val(),
				department :  $("#department").val()
		}

		// DO POST
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/ajaxProject/userRegister",
			data : formData,
			cache:false,
			async: false,
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
						$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
					"Registered Successfully! <br>" +
					"---> User's Info: userId =" +
					result.data.userId +
					",fName = " + result.data.fName +
					",mName = " + result.data.mName +
					",lName = " + result.data.lName +
					",addr = " + result.data.addr +
					",contactNumber = " + result.data.contactNumber +
					"department = " + result.data.department +"</p>");
		
					
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

		// Reset FormData after Posting
		resetData();

	}

	function resetData(){

		$("#userId").val("");
		$("#fName").val("");
		$("#mName").val("");
		$("#lName").val("");
		$("#addr").val("");
		$("#contactNumber").val("");
		$("#department").val("");
	}
})