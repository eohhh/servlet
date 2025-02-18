package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;
/*
 * Empolyee를 Student로 바꾸기
 * Student에 있는 변수들로 교체하기
 * resultSet의 get타입을 student클래스의 선언된 변수의 타입과 맞추기
 */
public class StudentDAO extends DAO{
	
	public boolean addStudent(Student student) {
		String sql = "insert into tbl_student (student_no, student_name, phone, address)"
				+ " values(?, ?, ?, ?)"; // values(?, ?, ?, ?) => 첫번째 물음표 : student_no, 두번째 : student_name... 각각 ?에 값을 담겠다.		
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, student.getStudentNo()); // 첫번째 ?값을
			psmt.setString(2, student.getStudentName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getAddress());
			
			// 쿼리실행.
			int r = psmt.executeUpdate(); // 처리된 건수반환.
			if (r > 0) {
				return true; // 등록성공.
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false; // 등록실패.
	}
	
	
	// 학생목록을 반환 메소드. 참고) EmpDAO.search()
	public List<Student> studentList() {
	List<Student> stuList = new ArrayList<>();
	String qry = "select * from tbl_student ";
	
	try {
		// 조회결과
//		Statement stmt = getConnect().createStatement();
		psmt = getConnect().prepareStatement(qry);
		rs = psmt.executeQuery();
		while (rs.next()) {
			Student stu = new Student();
			stu.setStudentNo(rs.getString("student_no"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setPhone(rs.getString("phone"));
			stu.setAddress(rs.getString("address"));

			stuList.add(stu);
		}
	} catch (SQLException e) {
		System.err.println(e);
	}
	return stuList;
	} // end of studentList()
}
