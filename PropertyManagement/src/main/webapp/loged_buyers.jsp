<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String email=session.getAttribute("email").toString();
String Table=session.getAttribute("UserType").toString();
if(email==null){
	response.sendRedirect("login.html");
}else{
	String user=db.DBC.GetName(Table, email);
	String welcome="Welcome "+user;
}
%>


<br>
<a href="Logout"><button type = "submit" >logout</button></a>
</form>
</body>
</html>