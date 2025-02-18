package com.yedam;

import java.util.List;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

public class Test {
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		List<Student> list = sdao.studentList();// StudentDAO가 가지고 있는 List컬렉션 반환.
		for ( Student std : list) {
			System.out.println(std.toString());
		}

	}
}