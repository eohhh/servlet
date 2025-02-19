package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override		
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title"); // req => Http에 있는 모든 행동들... 모든행동들에서 사용자가 title에 입력한 값을 저장하겠다.
		String content =  req.getParameter("content");
		String writer = req.getParameter("writer");
		
		
		//매개값으로 활용
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		BoardDAO bdao = new BoardDAO();
		if(bdao.insertBoard(bvo)) {
			// forward(매개값 활용) vs. redrect(매개값을 전달못함)
			resp.sendRedirect("boardList.do");
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
//		System.out.println("글등록");
	}

}
