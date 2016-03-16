<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mik" uri="/WEB-INF/Hello.tld" %>
<html>
<head>
<title>Cím</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/page?param=include">Oldal beágyazás</a> <br>
<a href="${pageContext.request.contextPath}/page?param=forward">Oldal továbbítás</a> <br><br>

<a href="${pageContext.request.contextPath}/book/bookList">Könyvek listája</a> <br><br> 
<%
request.setAttribute( "nevek", new String[]{"Béla","István","Dávid"} ); 
%>


<c:forEach items="${nevek}" var="nev">
	<mik:sayHello>${nev}</mik:sayHello><br/>
</c:forEach>

<mik:useSzorzo szam1 = "10" szam2 = "10"></mik:useSzorzo><br/>



</body> 
</html>