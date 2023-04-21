<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
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
				<table border=1px width=700px>
					<tr>
						<th>deptno</th>
						<th>name</th>
						<th>id</th>
						<th>pass</th>
						<th>addr</th>
						<th>point</th>
						<th>grade</th>
						<th>delete</th>
					</tr>

					<%
					ArrayList<EmpDTO> list = (ArrayList<EmpDTO>) request.getAttribute("emplist");
					int size = list.size();
					for (int i = 0; i < size; i++) {
					%>
					<tr>
						<%
						EmpDTO item = list.get(i);
						%>
						<td><%=item.getDeptno()%></td>
						<td><%=item.getName()%></td>
						<td><%=item.getId()%></td>
						<td><%=item.getPass()%></td>
						<td><%=item.getAddr()%></td>
						<td><%=item.getPoint()%></td>
						<td><%=item.getGrade()%></td>
						<td>
							<a href='/serverweb/mvc/delete.do?id="<%=list.get(i).getId()%>"'>삭제</a>
						</td>

					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>