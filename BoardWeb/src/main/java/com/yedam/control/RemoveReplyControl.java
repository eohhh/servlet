package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.ReplyDAO;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 댓글 번호
		String rno =req.getParameter("rno");
		System.out.println(rno);
		// DB.
		ReplyDAO rdao = new ReplyDAO();
		boolean run = rdao.deleteReply(Integer.parseInt(rno));
		System.out.println(run);
//		Map<String, Object> result = new HashMap<>();
		
		// json반환.
		if (run) {
			// {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
//			result.put("retCode", "OK");
//			result.put("retCode", );
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}

}
