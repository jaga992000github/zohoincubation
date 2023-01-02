<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="CSS/edit_properties.css">
<script src="JavaScript/jquery.min.js"></script>
<script src="JavaScript/edit_prop_json.js"></script>
<script src="JavaScript/edit_properties.js" defer>></script>
<script>

</script>
<title>Insert title here</title>
</head>
<body>
<body>
 <ul>
    <li class="navigate-li"><button id="show/edit" class="actlibutton-button">Show/Edit</button></li>
    <li class="navigate-li"><a href="loged_sellers.jsp"><button id="addprop_button"  class="libutton-button">Add property</button></a></li>
    <li class="navigate-li"><button id="profile_button" class="libutton-button">Profile</button></li>
    <li class="logout-li"><a href="Logout"><button type = "submit" class="logout-button">logout</button></a></li>
</ul>
 <table id="table">
        <tr><th>sno</th><th>name</th><th>age</th><th></tr>
       
    </table>
   <button onclick="receiveJsonFromJava()">receive</button>
     <button onclick="writeTable()">write</button>
      <button onclick="change()">change</button>

    
</body>
</html>