<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kapott könyv</title>
</head>
<body>
	<jsp:useBean id="book" class="hu.sol.mik.book.bean.Book" scope="request"/>
	Könyv Adatai: <br/><br/>
	Szerző: <jsp:getProperty property="author" name="book"/><br/>
	Cím: <jsp:getProperty property="title" name="book"/><br/>
	Leírás: <jsp:getProperty property="description" name="book"/><br/>
	Kiadás éve: <jsp:getProperty property="pubYear" name="book"/><br/>
</body>
</html>