<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Info</title>
		<script type="text/javascript">
			function getOrderDetails() {
				var uri = null;
				var orderId = null;
				var http = null;
				var order = null;
				
				uri = "http://localhost:8081/CustomContentHandler/rest/order/";
				orderId = document.getElementById("orderId").value;
				uri = uri + orderId;
				alert("uri : " + uri);
				
				
				if(window.XMLHttpRequest) {
					http = new XMLHttpRequest();
				}else {
					http = new ActiveXObject("Microsoft.XMLHttp");
				}
				http.onreadystatechange=function(){
					if(http.readyState == 4 && http.status == 200) {
						order = JSON.parse(http.responseText);		
						document.getElementById("orderdetailsdiv").innerHTML = "<b>Item Code : " + order.itemCode + " </b>";
					}
				}
				http.open("GET", uri, true);
				http.send(null);
			}
		</script>
	</head>
	<body>
		OrderId : <input type="text" id="orderId"/><br/>
		<input type="button" value="get details" onclick="javascript:getOrderDetails()"/>
		<div id="orderdetailsdiv">
		</div>
	</body>
</html>