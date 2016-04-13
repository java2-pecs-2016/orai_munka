<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<body>
	<form action="j_security_check" method="post">
		<table>
			<tr>
				<td>Felhasználó:</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td>Jelszó:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		
		</table>
	</form>
</body>
</html>