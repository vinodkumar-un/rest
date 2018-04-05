<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert Emp</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/rest/emp" method="POST">
     		empid:<input type="text" name="id"/><br/>
     		name:<input type="text" name="name"/><br/>
     		<input type="submit" value="insert"/>
  		</form>
	</body>
</html>