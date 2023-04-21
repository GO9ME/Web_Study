package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDTO;

/**
 * Servlet implementation class sendRedirectTestServlet
 */
@WebServlet(name = "Include", urlPatterns = { "/Include" })
public class IncludeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
	
		System.out.println("include 연습 - include 서블릿 실행");
		pw.println("<h1>요청재지정 연습 - sendRedirect</h1>");
		pw.println("<hr/><hr/><hr/>");
		// 1. 데이터 공유 - db에서 가져온 결과나 비지니스 로직 수행결과
		EmpDTO dto = new EmpDTO("bts", "1234", "서울", 100, "VIP");
		
		
		//공유하고 싶은 Scope를 나타내는 객체에 이름을 정의하고 저장
		request.setAttribute("mydata", dto);
		// 2. 요청 재지정
		RequestDispatcher dispatch = request.getRequestDispatcher("/basicview/result.jsp");
		dispatch.include(request, response);
	
	
	}

}
