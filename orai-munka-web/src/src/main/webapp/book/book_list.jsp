<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyvek listája</title>
</head>
<body>
	Könyvek:
	<table border="1" width="50%">
		<tr>
			<th>Id</th>
			<th>Cím</th>
			<th>Leírás</th>
			<th>Szerző</th>
			<th>Kiadás éve</th>
			<th></th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.description}</td>
				<td>${book.author}</td>
				<td>${book.pubYear}</td>
				<td>
					<a href="bookEdit?bookId=${book.id}">Szerkesztés</a><br>
					<a href="bookDetails?bookId=${book.id}">Megtekintés</a><br>
					<a>Törlés</a><br>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="bookEdit">Könyv felvitele</a><br>
	<c:if test="${empty bookList}">Nincs egyetlen könyv sem felvéve!</c:if>
</body>
</html>