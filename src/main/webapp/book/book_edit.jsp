<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv felvitele</title>
</head>
<body>
	Könyv adatainak megadása:<br/>
	<form action="bookEdit" method="post" accept-charset="UTF-8">
		<input type="hidden" name="id" value="${book.id}">
		Szerző: <input type="text" name="author" value="${book.author}"> <br/>
		Cím: <input type="text" name="title" value="${book.title}"> <br/>
		Leírás: <input type="text" name="description"  value="${book.description}"> <br/>
		Kiadás éve: <input type="text" name="pubYear"  value="${book.pubYear}"> <br/>
		<input type="submit">
	</form>
</body>
</html>