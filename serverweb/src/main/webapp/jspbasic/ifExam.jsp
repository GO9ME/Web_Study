<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- String 타입으로 id 변수를 정의한 후 id가 "java"인지 확인 
		if 문을 이용해서 id가 "java"인지 확인
		id가 "java"이면 bts.jpg를 출력하고
		id가 "java"가 아니면 bts2.jpg로 출력
	-->
	<%
	String id = "java";
	if (id.equals("java")) {
	%>
	<img src="../images/bts.jpg" width=300 height=500 alt="" />
	<%
	} else {
	%>
	<img src="../images/bts2.jpg" width=300 height=500 alt="" />
	<%
	}
	%>

</body>
</html>