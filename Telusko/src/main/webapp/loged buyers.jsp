<%@page import="db.DBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel = "stylesheet" href="CSS/loged buyers.css">
    <script type="text/javascript" src="JavaScript/loged buyers.js"></script>
    <script type="text/javascript" src="JavaScript/jquery.min.js"></script>
    <script type="text/javascript" >$(document).ready(function(){
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
      });  </script>
<title>Insert title here</title>
</head>
<body>
<%//String email=session.getAttribute("email").toString();
//String Table=session.getAttribute("UserType").toString();
//if(email==null){
	//response.sendRedirect("login.html");
//}else{
	//String user=db.DBC.GetName(Table, email);
	//out.print("welcome "+user);
//}
%>
<br>
<body>
  <ul>
    <li><button id="myprop_button" class="libutton-button">My properties</button></li>
    <li><button id="addprop_button"  class="actlibutton-button">Add property</button></li>
    <li><button id="editprop_button" class="libutton-button">Edit Properties</button></li>
    <li><button id="profile_button" class="libutton-button">Profile</button></li>
</ul>
<div id="addprop_div" class="addprop-position">
  <div id="proptype" >
    <button  class="active_proptype-button"id ="land"value="land">Land</button>
    <button id ="house"value="house">House</button>
  </div>
      <div id ="land_div">
        <form action="">
            <table>
                <tr><td>Location</td><td><select name="location">
                    <option value="Chennai">Chennai</option>
                    <option value="Thenkasi">Thenkasi</option>
                    <option value="Coimbatore">Coimbatore</option>
                  </select></td></tr>
                <tr><td>Area </td><td><input placeholder="in sqrft" type="number" name="area"></td></tr>
                <tr><td>DTCP aproval</td><td><input name ="dtcp"type="radio" value="yes">Yes</td></tr>
                <tr><td></td><td><input name="dtcp" type="radio" value="no">No</td></td></tr>
                <tr><td>Prefered for</td><td><select name="type">
                    <option value="farming">Farming</option>
                    <option value="house site">House Site</option>
                    <option value="comercial">Comercial</option>
                  </select></td></td></tr>
                <tr><td>Avaialavle Status</td><td><input name ="avail"type="radio" value="yes">Yes</td></tr>
                <tr><td></td><td><input name ="avail"type="radio" value="no">No</td></tr>
                <tr><td>Cost</td><td><input placeholder="total value" type="number" name="cost"></td></tr>
                <tr><td></td><td></td></tr>
            </table>
        </form>
    </div>
<div id ="house_div">
  <form action="">
    <table>
        <tr><td>Location</td><td><select name="location">
            <option value="Chennai">Chennai</option>
            <option value="Thenkasi">Thenkasi</option>
            <option value="Coimbatore">Coimbatore</option>
          </select></td></tr>
          <tr><td>Area </td><td><input placeholder="in sqrft" type="number" name="area"></td></tr>
          <tr><td>DTCP aproval</td><td><input name ="dtcp"type="radio" value="yes">Yes</td></tr>
          <tr><td></td><td><input name="dtcp" type="radio" value="no">No</td></td></tr>
          <tr><td>House type</td><td>
            <select name="type">
              <option value="pg">PG</option>
              <option value="sephouse">Seperate house</option>
              <option value="appartment">Appartment</option>
              <option value="comercial">Commercial</option>
              <option value="villa">Villa</option>
              <option value="office">Office</option>
            </select>
          </td></tr>
          <tr><td>Used for</td><td><select name="used for">
            <option value="rent">Rent</option>
            <option value="lease">Lease</option>
            <option value="sell">Sale</option>
          </select></td></tr>
          <tr><td>Prefered for</td><td><select name="aplicable for">
              <option value="mens">mens only</option>
              <option value="womens">womens only</option>
              <option value="family">family</option>
              <option value="All">All</option>
              <option value="comercial">comercial</option>
            </select></td></td></tr>
          <tr><td>Avaialavle from</td><td><input type="date"></td></tr>
          <tr><td>Highlights</td><td><input placeholder="2bhk,mordenkitchen,etc.." type="text"></td></tr>
          <tr><td>Cost</td><td><input placeholder="if rent monthly pay" type="number"></td></tr>
          <tr><td></td><td></td></tr>
        </table>
    </form>
</div>
  </div>

</body>
<a href="Logout"><button type = "submit" >logout</button></a>
</form>
</body>
</html>