<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri ="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
     <%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource  var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/login" user="root" password="992000"/>
<sql:query var ="rs" dataSource="${db}">select * from register</sql:query>

<c:forEach items="${rs.rows}" var="register">
<c:out value="${register.email}"></c:out>::::
<c:out value="${register.password}"></c:out>
</c:forEach>
</body>
</html>