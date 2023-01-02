var res;
function receiveJsonFromJava(){
	$.ajax({
	    url: 'EditProperties',
	    dataType: 'json',
	    type: 'POST',
	    contentType: 'application/json',
	    success: function( response ){
	     alert(JSON.stringify(response));
	     res=response;
	    },
	    error: function( jqXhr, textStatus, errorThrown ){
	    }
	});
}
