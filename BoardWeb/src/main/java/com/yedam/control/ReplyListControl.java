package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// 원본 글번호.
		String bno = req.getParameter("bno");   // 파라메타 정보를 읽어옴.
		
		// DAO활용.
		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.replyList(Integer.parseInt(bno)); 
		
		// gson활용.
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gsonbuilder.create를 활용해 Gson 문자를 가져옴.
		String json = gson.toJson(list); 		// list(매개값)을 문자열로 변환시켜줌. // 자바객체 => json 문자열
		
		System.out.println(json);				// 콘솔에 출력.
		resp.getWriter().print(json); 			// 웹브라우저에 출력.
	}

}
