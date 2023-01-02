 $(document).ready(function(){
  $("#house_div").hide();
  $("#land").addClass("active_proptype-button");
  $("#land").click(function(){
    $("#house").removeClass("active_proptype-button")
    $("#house").addClass("deactive_proptype-button");
    $("#house_div").hide();
    $("#land").removeClass("deactive_proptype-button");
    $("#land").addClass("active_proptype-button");
    $("#land_div").show();
  });
  $("#house").click(function(){
    $("#land").removeClass("active_proptype-button");
    $("#land").addClass("deactive_proptype-button");
    $("#land_div").hide();
    $("#house").removeClass("deactive_proptype-button");
    $("#house").addClass("active_proptype-button");
    $("#house_div").show();
  });
}); 

var land_json=[];
  function addLand(){
    selectElement1 = document.querySelector('#l_location');
    land_json[0] = selectElement1.value;
    land_json[1]=document.getElementById('l_area').value;
    land_json[2]=$("input[type='radio'][name='l_dtcp']:checked").val();
    selectElement2 = document.querySelector('#l_type');
    land_json[3]=selectElement2.value;
    land_json[4]=$("input[type='radio'][name='l_avail']:checked").val();
    land_json[5]=document.getElementById('l_cost').value;
  }
  function land(){
    
    addLand();
    send_land_JsonToJava(land_json); 
    alert('land saved');
  }
  function send_land_JsonToJava(json_obj){
	$.ajax({
	    url: 'LandSave',
	    dataType: 'json',
	    type: 'POST',
	    contentType: 'application/json',
	    data: JSON.stringify( json_obj),
	    success: function( response ){
	    },
	    error: function( jqXhr, textStatus, errorThrown ){
	    }
	});
}
function send_house_JsonToJava(json_obj){
	$.ajax({
	    url: 'HouseSave',
	    dataType: 'json',
	    type: 'POST',
	    contentType: 'application/json',
	    data: JSON.stringify( json_obj),
	    success: function( response ){
	    },
	    error: function( jqXhr, textStatus, errorThrown ){
	    }
	});
}
var house_json=[];
function addHouse(){
  selectElement1 = document.querySelector('#h_location');
  house_json[0] = selectElement1.value;
  house_json[1]=document.getElementById('h_area').value;
  house_json[2]=$("input[type='radio'][name='h_dtcp']:checked").val();
  selectElement2 = document.querySelector('#h_type');
  house_json[3]=selectElement2.value;
  selectElement3 = document.querySelector('#h_used_for');
  house_json[4]=selectElement3.value;
  selectElement4 = document.querySelector('#h_aplicable_for');
  house_json[5]=selectElement4.value;
  house_json[6]=document.getElementById('h_avail_from').value;
  house_json[7]=document.getElementById('bhk_no').value;
  house_json[8]=document.getElementById('h_highlights').value;
  house_json[9]=document.getElementById('h_cost').value;
}

  function house(){
    addHouse();
    send_house_JsonToJava(house_json); 
    alert('house saved');
  }
