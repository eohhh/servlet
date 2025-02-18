package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Employee;

// Data Access Object.

public class EmpDAO extends DAO {
	
	// 상세조회.
	public Employee selectEmp(int empNo) {
		String query = "select * from tbl_employees "
				+ "where emp_no = ?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, empNo);
			
			rs = psmt.executeQuery(); // 조회.
			if (rs.next()) { // 조회결과가 한건 있으면...
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no")); // 칼럼값. // set매소드를 통해서 emp에 값을 다 담음.
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("Salary"));
				
				return emp; // 반환.
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null; // 조회된 결과가 없을 경우 (null)
	}
	
	// Connection객체.
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클DB의 접속정보.
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	} // end of getConnect();
	
	
	//등록
	public boolean registerEmp(Employee emp) { // 등록
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query =  "insert into tbl_employees(emp_no,emp_name,tel_no )";
		query += "values (" +emp.getEmpNo() //
				+", '" +emp.getEmpName()
				+"', '" +emp.getTelNo()
				+"')";
		try {
			Statement stmt = getConnect().createStatement();
			int r =stmt.executeUpdate(query);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e ) {
			e.printStackTrace();
			return false;
		} return true;
	}
	// 목록
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		String qry = "select * from tbl_employees " //
//				+ "where emp_name = nvl('" + emp.getEmpName() + "', emp_name)" //
				+ "where emp_name = nvl(?, emp_name)" // number, varchar2에 따라서 알아서 처리. 문자타입인데 ''을 안해줘도 알아서 처리해줌. 숫자타입 => ''이 들어가있으면 알아서 빼고 처리.
				+ "order by emp_no";
		System.out.println(qry);
		try {
			// 조회결과
//			Statement stmt = getConnect().createStatement();
			PreparedStatement stmt = getConnect().prepareStatement(qry);
			stmt.setString(1, emp.getEmpName()); // 첫번째 ?에 사원이름을 대입.
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee empl = new Employee();
				empl.setEmpNo(rs.getInt("emp_no"));
				empl.setEmpName(rs.getString("emp_name"));
				empl.setHireDate(rs.getDate("hire_date"));
				empl.setSalary(rs.getInt("salary"));
				empl.setTelNo(rs.getString("tel_no"));

				empList.add(empl);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return empList;
	}
}
