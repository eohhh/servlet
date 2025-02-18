package com.yedam.vo;

import java.sql.Date;

public class BoardVO { // tbl_board	
	
	private int boardNo; // board_no값을 담기위해 int로 선언.
	// tilte.....view_cnt
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;

	public BoardVO() {
	}

	public BoardVO(int boardNo, String title, String content, String writer, Date writeDate, int viewCnt) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.viewCnt = viewCnt;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date write_date) {
		this.writeDate = write_date;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int view_cnt) {
		this.viewCnt = view_cnt;
	}

}
