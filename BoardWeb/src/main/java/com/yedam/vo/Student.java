package com.yedam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본생성자 (@Data를 해도 기본생성자는 없기 때문에 따로 생성)
@AllArgsConstructor
public class Student {
	private String studentNo;
	private String studentName;
	private String phone;
	private String address;
}
