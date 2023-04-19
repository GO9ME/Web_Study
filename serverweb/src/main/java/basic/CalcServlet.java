package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = resp.getWriter();
		String str = "";
		int result = 0;

		int num1 = Integer.parseInt(req.getParameter("num1"));
		String method = req.getParameter("method");
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		switch(method) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default : 
			break;
		}

		str += "<h1>계산 결과</h1>";
		str += "<hr>";

		str += "<h3>";
		str += " num1의 " + num1 + "과";
		str += " num2의 " + num2 + "를 연산한 결과는 ";
		str += result + "입니다.";
		str += "</h3>";

		pw.print(str);

	}
}
