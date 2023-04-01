<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginRegister" method="post">
<table>
<tr>
<td><h3>${Message}</h3> <h3>${successMessage}</h3></td>
<td></td>
</tr>
<tr><td>User Name:</td><td><input type="text" name="username"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password1"></td></tr>
<tr><td><input type="submit" name="submit" value="login"></td><td><a href="register.jsp">Registration</a></td></tr>
</table>
</form>
</body>
</html>