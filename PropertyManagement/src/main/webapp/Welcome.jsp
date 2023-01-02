<%@page import="com.mysql.cj.callback.UsernameCallback"%>
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
String user=session.getAttribute("UserType").toString();
if(email==null){
	response.sendRedirect("login.jsp");
}else{
	out.print("welcome "+user);
}
%>
<br><form action="Logout">
<button type = "submit" >logout</button>
</form>
</body>
</html>