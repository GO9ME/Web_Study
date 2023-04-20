package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpListServlet", urlPatterns = { "/emp/list.do" })
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
		if (list != null) {
			str += "<h1>회원목록 조회</h1>";
			str += "<table border='1px'>";
			str += "<tr>";
			str += "<th>deptno</th>";
			str += "<th>name</th>";
			str += "<th>id</th>";
			str += "<th>pass</th>";
			str += "<th>addr</th>";
			str += "<th>point</th>";
			str += "<th>grade</th>";
			str += "</tr>";
			for (int i = 0; i < list.size(); i++) {
				str += "<tr>";
				str += "<td>" + list.get(i).getDeptno() + "</td>";
				str += "<td>" + list.get(i).getName() + "</td>";
				str += "<td>" + list.get(i).getId() + "</td>";
				str += "<td>" + list.get(i).getPass() + "</td>";
				str += "<td>" + list.get(i).getAddr() + "</td>";
				str += "<td>" + list.get(i).getPoint() + "</td>";
				str += "<td>" + list.get(i).getGrade() + "</td>";
				str += "<td><a href='/serverweb/emp/delete.do?test=info&id="+list.get(i).getId()+"'>삭제</a></td>";
				str += "</tr>";
			}

			str += "</table>";

		} else {
			str = "<h1>조회 실패</h1>";
		}

		pw.print(str);
	}
}
