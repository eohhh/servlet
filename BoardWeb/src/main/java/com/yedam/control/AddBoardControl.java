package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override		
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 2종류의 파일타입 (multipart) => 이미지 파일 업로드과정.
		String saveDir = req.getServletContext().getRealPath("images"); // getServletContext=> 서버가 있는 경로의 getRealPath => 이미지 경로의 실제 경로를 읽어옴.
		MultipartRequest mr = new MultipartRequest(
				req  		// 1.요청 객체
			   ,saveDir	    // 2.파일저장경로
			   ,1024*1024*5	// 3.최대파일크기
			   ,"utf-8"     // 4. 인코딩 
			   ,new DefaultFileRenamePolicy() // 5. 리네임정책(중복파일의 파일명을 새롭게 지정.)	
				);
		
		// 3개의 파라미터 활용 db 저장. 목록으로 이동.
//		String title = req.getParameter("title"); // req => Http에 있는 모든 행동들... 모든행동들에서 사용자가 title에 입력한 값을 저장하겠다.
//		String content =  req.getParameter("content");
//		String writer = req.getParameter("writer");
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		
//		//매개값으로 활용
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		bvo.setImg(img); // 추가한 img컬럼.
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
