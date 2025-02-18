package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	// 조회
	public List<BoardVO> selectBoard() {
		List<BoardVO> borList = new ArrayList<>();
		String query = "select * from tbl_board ";

		try {
			psmt = getConnect().prepareStatement(query);

			rs = psmt.executeQuery(); // 조회.
			while (rs.next()) { // 조회결과가 한건 있으면...
				BoardVO br = new BoardVO();
				br.setBoardNo(rs.getInt("board_no")); // 칼럼값. // set매소드를 통해서 emp에 값을 다 담음.
				br.setTitle(rs.getString("title"));
				br.setContent(rs.getString("content"));
				br.setWriteDate(rs.getDate("write_date"));
				br.setWriter(rs.getString("writer"));
				br.setViewCnt(rs.getInt("view_cnt"));

				borList.add(br); // 반환.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borList;
	}

	// 추가
	public boolean insertBoard(BoardVO board) {

		return false;
	}

	// 수정
	public boolean updateBoard(BoardVO board) {

		return false;
	}

	// 삭제
	public boolean deleterBoard(int BoardNo) {

		return false;
	}
}
