package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.CustomerVO;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		String str = "";

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		CustomerDAO cDAO = new CustomerDAOImpl();
		CustomerVO cVO = cDAO.login(id, pass);
		if (cVO == null) {
			str += "<h1> 로그인 실패 </h1>";
		} else {
			str += "<h1> 로그인 성공 </h1>";			
		}
		
		pw.print(str);
	}
}
