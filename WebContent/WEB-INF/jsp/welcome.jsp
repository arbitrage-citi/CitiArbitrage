<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<center>Welcome ${loggedInUser}</center>
	<form action="${pageContext.request.contextPath}/MyServlet" method="post">
    <input type="submit" name="button1" value="BSE" />
    <input type="submit" name="button2" value="NSE" />
    <input type="submit" name="button3" value="Save" />
    <p>${value}</p>
</form>
</body>
</html>