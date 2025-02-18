package com.yedam.vo;

public class Student {
	private String studentNo;
	private String studentName;
	private String phone;
	private String address;
	
	public Student() {
		
	}
	public Student(String sno, String sname, String pho, String add) {
		this.studentNo = sno;
		this.studentName = sname;
		this.phone = pho;
		this.address = add;
		
	}
	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
