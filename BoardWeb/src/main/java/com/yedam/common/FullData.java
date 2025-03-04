package com.yedam.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.control.Control;
import com.yedam.mapper.ReplyMapper;

public class FullData implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		// DB
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		List<Map<String, Object>> list = mapper.fullData();

		// 웹.출.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);

		resp.getWriter().print(json);
	}

}
