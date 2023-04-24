package kr.multicampus.erp.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "boardWrite", urlPatterns = { "/board/write.do" })
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("서블릿 요청 성공");

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

//		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String writer = req.getParameter("id");
		String content = req.getParameter("content");
//		String writeDate = req.getParameter("writeDate");
		
		BoardDTO dto = new BoardDTO(title, writer, content);
		BoardDAO dao = new BoardDAOImpl();
		int result = dao.insert(dto);
		

		if (result > 0 ) {
			resp.sendRedirect("/serverweb/board/list.do");
		} else {
			resp.sendRedirect("/serverweb/board/list.do");
		}
	}
}
