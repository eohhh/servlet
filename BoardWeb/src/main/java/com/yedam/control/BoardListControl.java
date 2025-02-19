package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "홍길동";
		// boardList.do -> (BoardListcontrol) -> boardList.jsp
		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = edao.selectBoard();
		req.setAttribute("list", list);

		// 요청재지정(원래 url은 boardList.do인데 -> getRequestDispatcher을 써서 boardList.jsp로 재지정.)
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);
	}

}
