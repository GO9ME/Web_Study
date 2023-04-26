package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "EmpRead", urlPatterns = { "/mvc/read.do" })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String id = req.getParameter("id");
		EmpDTO emp = new EmpDTO();

		EmpDAO dao = new EmpDAOImpl();
		emp = dao.getEmpInfo(id);
		if (emp != null) {
			
			req.setAttribute("empdata", emp);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/user_mvc/emp_read.jsp");
		rd.forward(req, resp);

	}
}
