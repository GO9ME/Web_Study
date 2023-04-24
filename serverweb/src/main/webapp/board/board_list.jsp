<%@page import="kr.multicampus.erp.board.BoardDTO"%>
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
				<jsp:include page="/layout/board_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<table border=1px width=700px>
					<tr>
						<th>boardNo</th>
						<th>제목</th>
						<th>작성자</th>
						<th>내용</th>
						<th>작성시간</th>
					</tr>

					<%
					ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("boardlist");
					int size = list.size();
					for (int i = 0; i < size; i++) {
					%>

					<tr>
						<%
						BoardDTO item = list.get(i);
						%>

						<td>
							<a href='/serverweb/board/read.do?id=<%=item.getBoardNo()%>'><%=item.getBoardNo()%></a>
						</td>
						<td><%=item.getTitle()%></td>
						<td><%=item.getWriter()%></td>
						<td><%=item.getContent()%></td>
						<td><%=item.getWriteDate()%></td>
						<td>

							<a href='/serverweb/board/delete.do?id=<%=item.getBoardNo()%>'>삭제</a>
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