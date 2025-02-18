package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;

/*
 * MVC에서 Control역할.
 * url요청 -> 서블릿.
 */

@WebServlet("*.do") // 끝에 .do로 끝나는 url은 이 페이지를 실행.
public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>(); // map 필드에 초기화 작업.
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		map.put("url", "servlet"); // addStudent.do => AddStudentServlet으로 실행. ( .do => servlet )
		map.put("/boardList.do", new BoardListControl());
		map.put("/addBoard.do", new AddBoardControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("front control");
		// http://localhost:8080/BoardWeb/addStudent.do => url
		// /BoardWeb/addStudent.do => uri.라고 함.
		String uri = req.getRequestURI(); // /BoardWeb/addStudent.do (uri)
		String context = req.getContextPath(); // ContextPath => 프로젝트 이름부분이라고 생각.(/BoardWeb)
		String page = uri.substring(context.length()); // 마지막 부분을 가져옴. ( /addStudent.do)
		
		System.out.println(page);
		// map컬렉션에서 key를 입력하면 val반환. (get 매소드)
		Control control = map.get(page);
		control.exec(req, resp);
	}
}
