<%@page import="db.DBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel = "stylesheet" href="CSS/loged_sellers.css">
  <script src="JavaScript/jquery.min.js"></script>
    <script src="JavaScript/loged_sellers.js"></script>
   
    <script> 
     
    </script>
<title>Insert title here</title>
</head>
<body>
<%

%>
<br>

  <ul>
    <li class="navigate-li"><button id="myprop_button" class="libutton-button">My properties</button></li>
    <li class="navigate-li"><button id="addprop_button"  class="actlibutton-button">Add property</button></li>
    <li class="navigate-li"><button id="editprop_button" class="libutton-button">Edit Properties</button></li>
    <li class="navigate-li"class="navigate-li"><button id="profile_button" class="libutton-button">Profile</button></li>
    <li class="logout-li"><a href="Logout"><button type = "submit" class="logout-button">logout</button></a></li>
</ul>
<div id="addprop_div" class="addprop-position">
  <div id="proptype" >
    <button  class="active_proptype-button"id ="land"value="land">Land</button>
    <button id ="house"value="house">House</button>
  </div>
      <div id ="land_div">
            <table>
                <tr><td>Location</td><td><select id="l_location">
                    <option value="Chennai">Chennai</option>
                    <option value="Thenkasi">Thenkasi</option>
                    <option value="Coimbatore">Coimbatore</option>
                  </select></td></tr>
                <tr><td>Area </td><td><input placeholder="in sqrft" type="number" id="l_area"></td></tr>
                <tr><td>DTCP aproval</td><td><input name ="l_dtcp"type="radio" value="yes">Yes</td></tr>
                <tr><td></td><td><input name="l_dtcp" type="radio" value="no">No</td></td></tr>
                <tr><td>Prefered for</td><td><select id="l_type">
                    <option value="farming">Farming</option>
                    <option value="house site">House Site</option>
                    <option value="comercial">Comercial</option>
                  </select></td></td></tr>
                <tr><td>Avaialavle Status</td><td><input name ="l_avail"type="radio" value="yes">Yes</td></tr>
                <tr><td></td><td><input name ="l_avail"type="radio" value="no">No</td></tr>
                <tr><td>Cost</td><td><input placeholder="total value" type="number" id="l_cost"></td></tr>
                <tr><td></td><td><button name="proptype" value="land" onclick="land()" >Add</button></td></tr>
            </table>
    </div>
<div id ="house_div">
    <table>
        <tr><td>Location</td><td><select id="h_location">
            <option value="Chennai">Chennai</option>
            <option value="Thenkasi">Thenkasi</option>
            <option value="Coimbatore">Coimbatore</option>
          </select></td></tr>
          <tr><td>Area </td><td><input placeholder="in sqrft" type="number" id="h_area"></td></tr>
          <tr><td>DTCP aproval</td><td><input name ="h_dtcp"type="radio" value="yes">Yes</td></tr>
          <tr><td></td><td><input name="h_dtcp" type="radio" value="no">No</td></td></tr>
          <tr><td>House type</td><td>
            <select id="h_type">
              <option value="pg">PG</option>
              <option value="sephouse">Seperate house</option>
              <option value="appartment">Appartment</option>
              <option value="comercial">Commercial</option>
              <option value="villa">Villa</option>
              <option value="office">Office</option>
            </select>
          </td></tr>
          <tr><td>Used for</td><td><select id="h_used_for">
            <option value="rent">Rent</option>
            <option value="lease">Lease</option>
            <option value="sell">Sale</option>
          </select></td></tr>
          <tr><td>Prefered for</td><td><select id="h_aplicable_for">
              <option value="mens">mens only</option>
              <option value="womens">womens only</option>
              <option value="family">family</option>
              <option value="All">All</option>
              <option value="comercial">comercial</option>
            </select></td></td></tr>
          <tr><td>Avaialavle from</td><td><input type="date" id="h_avail_from"></td></tr>
          <tr><td>Highlights</td><td><input placeholder="2bhk,mordenkitchen,etc.." type="text" id="h_highlights"></td></tr>
          <tr><td>Cost</td><td><input placeholder="if rent monthly pay" type="number" id="h_cost"></td></tr>
          <tr><td></td><td><button name="proptype" value="house" onclick="house()">Add</button></td></tr>
        </table>
</div>
  </div>

</body></html>