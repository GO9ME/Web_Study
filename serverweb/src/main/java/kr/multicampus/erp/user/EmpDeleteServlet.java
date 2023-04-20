package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empdelete", urlPatterns = { "/emp/delete.do" })
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String test = req.getParameter("test");
		String id = req.getParameter("id");
		String str = "";
		PrintWriter pw = resp.getWriter();

		EmpDAO dao = new EmpDAOImpl();
		int result = dao.delete(id);
		if (result > 0) {
			str = "<h1>삭제완료</h1>";
		} else {
			str = "<h1>삭제실패</h1>";
		}
		pw.print(str);
	}
}
