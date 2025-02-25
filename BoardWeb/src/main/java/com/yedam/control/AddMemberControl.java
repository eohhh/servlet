package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");
		String name = req.getParameter("mname");

		MemberDAO mdao = new MemberDAO();

		boolean isOk = mdao.addMember(id, pw, name);
		
		if (isOk) {
			// {"retCode": "OK"} 삭제되면 OK 반환.
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
			// {"retCode": "NG"} 삭제가 안되면 NG 반환.
		}
	}

}
