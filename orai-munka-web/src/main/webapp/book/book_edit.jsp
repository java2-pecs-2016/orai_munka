<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv felvitele</title>
</head>
<body>
	
	Könyv adatainak megadása:<br/>
	<form:form action="bookEdit" method="post" accept-charset="UTF-8" modelAttribute="book">
		<form:hidden path="id" />
		Szerző: <form:input path="author" /> <br/>
		Cím: <form:input path="title" /> <br/>
		Leírás: <form:input path="description" /> <br/>
		Kiadás éve: <form:input path="pubYear" /> <br/>
		<input type="submit">
	</form:form>
</body>
</html>