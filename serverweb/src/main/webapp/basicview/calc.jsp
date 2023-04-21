<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<form method="post" action="/serverweb/calc.do">
					<input type="text" name="num1" />
					<select name="method">
						<option value="+">+
						<option value="-">-
						<option value="*">*
						<option value="/">/
					</select>
					<input type="text" name="num2" />
					<input type="submit" value="전송" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>
