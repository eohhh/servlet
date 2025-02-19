package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		BoardDAO bdao = new BoardDAO();
		bdao.updateCount(Integer.parseInt(bno)); // 코드의 순서에 따라 조회를 하고 업데이트를 할 것인지 , 그전에 할것인지를 정함. (이 위치는 실시간 반영. 밑에 코드랑 위치가 바뀌면 조회 후에 반영됨.)
		BoardVO board = bdao.getBoard(Integer.parseInt(bno)); // 문자열 "14" -> int 14로 변경하려고 선언.
		// 요청정보의 attribute활용.
		req.setAttribute("board", board); // 
		req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
	}

}
