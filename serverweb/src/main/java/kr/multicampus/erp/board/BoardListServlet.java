package kr.multicampus.erp.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "boardList", urlPatterns = { "/board/list.do" })
public class BoardListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAOImpl();
		ArrayList<BoardDTO> list = dao.select();

		if (list != null) {
			req.setAttribute("boardlist", list);

			RequestDispatcher rd = req.getRequestDispatcher("/board/board_list.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("/serverweb/index.jsp");
		}
	}
}
