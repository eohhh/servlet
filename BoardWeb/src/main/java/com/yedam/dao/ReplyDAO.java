package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.ReplyVO;

// 댓글목록, 등록, 삭제, 상세조회.
public class ReplyDAO extends DAO {

	// 목록.
	public List<ReplyVO> replyList(int boardNo) {
		String sql = "select reply_no "//
				+ "         ,reply "//
				+ "         ,replyer"//
				+ "         ,reply_date"//
				+ "         ,board_no"//
				+ "   from tbl_reply "//
				+ "   where board_no = ?";
		List<ReplyVO> list = new ArrayList<>();
		// 조회.
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery(); // 쿼리실행.

			while (rs.next()) { // 조회된 결과가 있으면.
				ReplyVO reply = new ReplyVO();
				reply.setBoardNo(rs.getInt("board_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyDate(rs.getDate("reply_date"));
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReplyer(rs.getString("replyer"));

				list.add(reply); // 건수만큼 list추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 상세.
	public ReplyVO selectReply(int replyNo) {
		String sql = "select reply_no "//
				+ "         ,reply "//
				+ "         ,replyer"//
				+ "         ,reply_date"//
				+ "         ,board_no"//
				+ "   from tbl_reply "//
				+ "   where reply_no = ?";

		// 조회.
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, replyNo);
			rs = psmt.executeQuery(); // 쿼리실행.

			while (rs.next()) { // 조회된 결과가 있으면.
				ReplyVO reply = new ReplyVO();
				reply.setBoardNo(rs.getInt("board_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyDate(rs.getDate("reply_date"));
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReplyer(rs.getString("replyer"));

				return reply;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// 등록.
	public boolean insertReply(ReplyVO reply) {
		String query1 = "select reply_seq.nextval from dual";
		String query = "insert into tbl_reply (reply_no, reply, replyer, board_no) "
					   + "values(?, ?, ?, ?)";
		try {
			psmt = getConnect().prepareStatement(query1);
			rs = psmt.executeQuery();
			if(rs.next()) { 
				reply.setReplyNo(rs.getInt(1)); // 첫번째 컬럼.
			}
			
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, reply.getReplyNo());
			psmt.setString(2, reply.getReply()); // ?에 값 지정.
			psmt.setString(3, reply.getReplyer()); // ?에 값 지정.
			psmt.setInt(4, reply.getBoardNo()); // ?에 값 지정.
			int r = psmt.executeUpdate(); // 쿼리 실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false;
	}

	// 삭제.
	public boolean deleteReply(int replyNo) {
		String query = "delete from tbl_reply where reply_no = ?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, replyNo); // ?에 값 지정.
			int r = psmt.executeUpdate(); // 쿼리 실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false;
	}

}
