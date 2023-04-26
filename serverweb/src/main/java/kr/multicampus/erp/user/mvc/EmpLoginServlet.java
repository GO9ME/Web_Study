package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "emplogin", urlPatterns = { "/mvc/login.do" })
public class EmpLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("서블릿 요청 성공");

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		EmpDAO dao = new EmpDAOImpl();
		EmpDTO emp = dao.login(id, pass);
		
		// 3. 데이터 공유 - 사이트를 이용하는 동안 로그인이 계속 유지되어야 서비스가 가능한 기능들이 있으므로 로그인 정보를 세션객체에 저장한다
		// 3-1) 세션 객체를 만들기
		// 1) getSession()
		/*
			- request에서 세션 id를 꺼내고 서버에 할당된 세션의 세션id와 일치하는게 없거나 세션id가 존재하지 안흥면
			무조건 세션을 HttpSession객체로 만들어서 리턴한다.
			- 일치하는 세션id가 있으면 그 세션id로 정의된 세션을 HttpSession객체로 만들어서 리턴한다.
			ex) 로그인 버튼을 눌러서 로그인에 성공하면 세션을 무조건 생성
			
			2) getSession(true) - 1 번과 동일
			3) getSession(false) 
			- 일치하는 세션id가 존재하면 세션객체를 만들어서 리턴
			- 일치하는 세션 id가 존재하지 않으면 null을 리턴
			ex) 세션객체를 체크하는 경우 ( 로그아웃 ) 
		*/		
		if (emp != null) {
//			req.setAttribute("empdata", emp);
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", emp);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("/serverweb/user_mvc/login.jsp");
		}
	}
}
