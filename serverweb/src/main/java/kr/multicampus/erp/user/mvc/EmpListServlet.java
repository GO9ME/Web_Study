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

@WebServlet(name = "list_mvc", urlPatterns = { "/mvc/list.do" })
public class EmpListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = resp.getWriter();
		String str = "";
		ArrayList<EmpDTO> list = new ArrayList<>();
		
		EmpDAO dao = new EmpDAOImpl();
		list = dao.select();
		
		if (list != null ) {
			req.setAttribute("emplist", list);
		} 
		
		RequestDispatcher rd = req.getRequestDispatcher("/user_mvc/list.jsp");
		rd.include(req, resp);

	}
}
