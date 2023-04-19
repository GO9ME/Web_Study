package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = resp.getWriter();
		String str = "";

		String userId = req.getParameter("userId");
		String name = req.getParameter("userName");
		String passwd = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] items = req.getParameterValues("item");

		str += "<h1>Customer</h1>";
		str += "<hr>";
		str += "<h1>아이디 : " + userId + "</h1>";
		str += "<h1>성명 : " + name + "</h1>";
		str += "<h1>패스워드 : " + passwd + "</h1>";
		str += "<h1>성별 : " + gender + "</h1>";
		str += "<h1>직업 : " + job + "</h1>";
		str += "<h1>좋아하는 항목 : ";
		for (int i = 0; i < items.length; i++) {
			str += items[i] + "&nbsp";
		}
		str += "</h1>";

		pw.print(str);

	}
}
