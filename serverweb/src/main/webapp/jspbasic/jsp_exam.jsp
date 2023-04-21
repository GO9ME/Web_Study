<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width=700;>
		<% for (int i=1 ; i <= 9; i++ ){%>
		<tr>
			<% for (int j=1 ; j<=9 ; j++){ 
			if (i == j ) {%>
			<td><img src="../images/bts.jpg" width=50 height=50></td>
			<%} else {%>
			<td><%= i +"*"+ j +"=" +(i*j) %></td>			
			<%}%>
		<%}%>
		</tr>
		<%}%>

	</table>
</body>
</html>