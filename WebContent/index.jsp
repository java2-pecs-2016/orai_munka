<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mik" uri="/WEB-INF/Hello.tld" %>
<html>
<head>
<title>Cím</title>
</head>
<body>
<%
request.setAttribute( "nevek", new String[]{"Béla","István","Dávid"} ); 
%>


<c:forEach items="${nevek}" var="nev">
	<mik:sayHello>${nev}</mik:sayHello><br/>
</c:forEach>

<mik:useSzorzo szam1 = "10" szam2 = "10"></mik:useSzorzo><br/>



</body> 
</html>