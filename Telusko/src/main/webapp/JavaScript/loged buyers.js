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