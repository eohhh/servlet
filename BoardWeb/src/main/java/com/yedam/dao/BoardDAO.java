package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {
	
	// 글 조회수 증가.
	public void updateCount(int boardNo) {
		String sql = "update tbl_board"
				+ "   set    view_cnt = view_cnt + 1"
				+ "   where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql); // getConnect => 데이터베이스에 연결을 반환하는 매서드.
			psmt.setInt(1, boardNo);
			psmt.executeUpdate(); // 쿼리 실행.
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 상세조회. 글번호 => 전체정보 반환.
	public BoardVO getBoard(int boardNo) {
			
		String sql = "select board_no"  // sql = 스트럭쳐 쿼리 랭귀지 ..
					+"      ,title"
					+"      ,content"
					+"      ,writer"
					+"      ,write_date"
					+"      ,view_cnt"
					+"      from tbl_board"
					+"      where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			rs = psmt.executeQuery();
			// 조회결과가 존재하면..
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setContent(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				// 결과반환.
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회결과 없음.
	}

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
	public boolean insertBoard(BoardVO board) {   		// DB 컬럼에 값을 저장하기 위함.
		String sql = "insert into tbl_board (board_no, title, content, writer)"
				+ "   values(board_seq.nextval,?,?,?)";
//		psmt = getConnect().prepareStatement(sql); -> 2번째 try-catch
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			
			int r = psmt.executeUpdate(); // insert 쿼리 실행. (Update)
			if (r == 1) {
				return true; //정상 등록.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상 등록.
	}

	// 수정
	public boolean updateBoard(BoardVO board) {
		String sql = "update tbl_board "
				+ "set      title = ? "
				+ "        ,content = ? "
				+ "where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql); // getConnect => 데이터베이스에 연결을 반환하는 매서드.
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			
			int r = psmt.executeUpdate(); // 쿼리 실행.
			if (r > 0) {
				return true; // 정상수정완료.
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false; // 수정실패.
	}

	// 삭제
	public boolean deleterBoard(int BoardNo) {

		return false;
	}
}
