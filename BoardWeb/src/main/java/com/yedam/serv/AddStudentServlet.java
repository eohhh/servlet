package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

@WebServlet("/addStuServlet")
public class AddStudentServlet extends HttpServlet {
	// paramater 의 값을 활용 -> db 입력.
	// 등록되면 처리성공. / 처리실패 메세지.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		?empNo=1004&empName=Kim&telNo=654-0107
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String stdNo = req.getParameter("std_No"); // empNo의 parameter에 담겨있는 값 반환.
		String stdna = req.getParameter("std_Name");
		String stdt = req.getParameter("tel_No");
		String addr = req.getParameter("std_addr");
		
		// db등록.
		StudentDAO sdao = new StudentDAO();
		
		boolean result = sdao.addStudent(new Student(stdNo, stdna, stdt, addr));
		if (result) {
			resp.getWriter().print("처리성공");
		//	resp.sendRedirect("sample"); // addEmpServlet -> sample로 이동.
		} else {
			resp.getWriter().print("처리실패");			
		}
	}
}
