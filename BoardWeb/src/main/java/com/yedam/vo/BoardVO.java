package com.yedam.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok을 활용하는법.

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO { // tbl_board	
	
	private int boardNo; // board_no값을 담기위해 int로 선언.
	// tilte.....view_cnt
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;
	private String img;

	
}
