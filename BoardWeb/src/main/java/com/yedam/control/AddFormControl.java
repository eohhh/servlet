package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);
		// 3개파라미터 활용 db 저장. 목록으로 이동
		
	}

}
