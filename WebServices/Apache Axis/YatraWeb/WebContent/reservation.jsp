<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>reservation</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/reservation">
			<table>
				<tr>
					<!-- Travel Info -->
					<td>
						<table>
							<tr>
								<td>src:</td>
								<td>
									<input type="text" name="src"/>
								</td>								
							</tr>
							<tr>
								<td>dest:</td>
								<td>
									<input type="text" name="dest"/>
								</td>								
							</tr>
							<tr>
								<td>Date of journey:</td>
								<td>
									<input type="text" name="doj"/>
								</td>								
							</tr>
						</table>
					</td>
					<!-- Passenger Info -->
					<td>
						<table>
							<tr>
								<td>ssn:</td>
								<td>
									<input type="text" name="ssn"/>
								</td>								
							</tr>
							<tr>
								<td>name:</td>
								<td>
									<input type="text" name="name"/>
								</td>								
							</tr>
							<tr>
								<td>Age:</td>
								<td>
									<input type="text" name="age"/>
								</td>								
							</tr>
						</table>
					</td>					
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="book"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>