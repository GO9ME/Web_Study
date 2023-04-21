package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "empInsert_mvc", urlPatterns = {"/mvc/insert.do"})
public class EmpInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("서블릿 요청 성공");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

//		PrintWriter pw = resp.getWriter();
		String str = "";

		String deptno = req.getParameter("deptno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String addr = req.getParameter("addr");
		String grade = req.getParameter("grade");
		
		EmpDTO dto = new EmpDTO(deptno, name, id, pass, addr, grade);
		EmpDAO dao = new EmpDAOImpl();
		int result = dao.insert(dto);
		
		/*
		 * if (result > 0 ) { str += "<h1> 사원 등록 성공 </h1>"; } else { str +=
		 * "<h1> 사원 등록 성공 </h1>"; } pw.print(str);
		 */
		
		// 서블릿에서 바로 응답화면을 만들지 않고 응답할 뷰를 지정해서 실행되도록 처리
		String view = ""; // 응답할 view에 대한 정보
		
		//3. 데이터 공유
		req.setAttribute("insertuser", name);
		//4. 요청재지정
		if ( result > 0) { // 정상처리
			
			view = "/user_mvc/insertOK.jsp";
		} else { 
			view = "/user_mvc/insertFail.jsp";
		}
		
		RequestDispatcher rd= req.getRequestDispatcher(view);
		rd.forward(req, resp);
		//응답 뷰가 클라이언트에게 response 되도록 재요청
		//resp.sendRedirect(view);
	}
}
