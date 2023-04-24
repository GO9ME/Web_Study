package kr.multicampus.erp.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "boardDetail", urlPatterns = { "/board/read.do" })
public class BoardDetailServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		int id = Integer.parseInt(req.getParameter("id"));
		BoardDTO dto = new BoardDTO();

		BoardDAO dao = new BoardDAOImpl();
		dto = dao.read(id);

		if (dto != null) {
			req.setAttribute("board", dto);

			RequestDispatcher rd = req.getRequestDispatcher("/board/board_detail.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("/serverweb/board/list.do");
		}

	}
}
