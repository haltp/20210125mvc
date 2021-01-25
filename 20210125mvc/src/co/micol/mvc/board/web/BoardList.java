package co.micol.mvc.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardsDAO dao = new BoardsDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectList(); //실제 테이블에 접속해서 list를 가져온다.
		request.setAttribute("list", list);
		String viewPage = "views/board/boardList.jsp"; //결과를 보여줄 페이지
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
