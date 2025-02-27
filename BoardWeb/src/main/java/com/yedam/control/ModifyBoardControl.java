package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ?bno=22&title=test&content=testing
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardVO board = new BoardVO(); // 메소드의 파라미터.
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);

//		BoardDAO bdao = new BoardDAO();
		if (mapper.updateBoard(board) == 1) { 
			resp.sendRedirect("boardList.do"); // 수정이 완료되면 boardList.do로 이동.
		} else {
			System.out.println("처리실패."); // 0값이 입력되면 처리실패.
		}

	}

}
