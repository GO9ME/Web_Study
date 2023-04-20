<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp 문법</h2>
	<h3>1. 주석문</h3>
	<!-- HTML 주석(클라이언트에 전송) -->
	<%-- jsp 주석( jsp 태그를 주석처리하기 위해서 사용 : 클라이언트에 전송되지 않는다.) --%>
	<%
	// 자바 주석문
	/* 
	자바 주석문은 클라이언트에 전송 되지 않는다.
	 */
	%>
	<h3>2. 스크립트요소 - 스크립트릿</h3>
	<h4>자바 코드를 쓸 수 있는 스크립트 요소</h4>
	<%
	// 자바 코드를 쓸 수 있는 영역 
	// 반드시 명령문인 경우 문장에 끝에 ;를 추가해야 한다
	// 자바나 서블릿에서 쓸 수 있는 모든 코드를 사용할 수 있음. 
	// 단, jsp는 만들어진 목적이 서블릿에서 view를 분리하기 위함 jsp에서는 자바코드를 지양
	// 서블릿(스프링인 경우 controller)에서 공유한 데이터를 꺼내서 출력하는 작업만 정의
	// 자바코드는 쓰지말자 (EL, JSTL 만들어짐)

	String str = new String("java~!~~~");
	%>
	<h4>스크립트릿은 여러번 선언해서 사용할 수 있음</h4>
	<%
	System.out.println("str = " + str);
	%>
	<hr />
	<%
	if (str.length() >= 5) {
	%>
	<h3>문자열길이 정상</h3>
	<%}else{ %>
	<h3>문자열길이 다시처리하기</h3>
	<%} %>
	
	<h3>2. 스크립트요소 - 표현식(변수, 메소드호출결과(리턴값이 있는 메소드의 호출), 문자열, 연산식등을 출력하기 위해 사용)</h3>
	<h4>서블릿으로 변홚될때 out.print메소드의 매개변수로 전달되므로 ;을 추가하지 않는다.</h4>
	<h4>표현식으로 작성하는 값 : <%= str %></h4>
	<h4>표현식으로 작성하는 값 : <%= str.length() %></h4>
	<h4>표현식으로 작성하는 값 : <%= "str" %></h4>
	<h4>표현식으로 작성하는 값 : <%= 10 %></h4>
	<h4>표현식으로 작성하는 값 : <%= 10.0 %></h4>
	<h4>표현식으로 작성하는 값 : <%= 'A' %></h4>
	<h4>표현식으로 작성하는 값 : <%= true %></h4>
	<h4>표현식으로 작성하는 값 : <%= 10/3 %></h4>
	<h4>표현식으로 작성하는 값 : <%= new Date().toString() %></h4>
	
	<h3>3. 스크립트요소 - 선언문</h3>
	<%
		int num = 1000; // _jspService 메소드의 지역변수로 정의
	%>
	
	<%! int num = 1000000; //맴버변수로 정의 %>
	<%! public void test(){
		System.out.println(num);
	}
	%>	
	
	
</body>
</html>