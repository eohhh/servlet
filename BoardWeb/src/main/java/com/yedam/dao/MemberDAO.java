package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.MemberVO;

public class MemberDAO extends DAO {

	public boolean deleteMember(String id) {
		String query = "delete from tbl_member" + " where member_id = ?";

		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setString(1, id); // ?에 값 지정.
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addMember(String id, String pw, String name) {
		String query = " INSERT INTO tbl_member (member_id, passwd, member_name ) "
						+ "    VALUES(?, ?, ?)";
			try {
				psmt = getConnect().prepareStatement(query);
				psmt.setString(1, id); // ?에 값 지정.
				psmt.setString(2, pw); // ?에 값 지정.
				psmt.setString(3, name); // ?에 값 지정.
				int r = psmt.executeUpdate();
				if (r > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
	public List<MemberVO> members() {
		String sql = "select member_id"//
				+ "         ,passwd"//
				+ "         ,member_name"//
				+ "         ,responsbility"//
				+ "   from tbl_member ";//
		List<MemberVO> list = new ArrayList<>();

		try {
			psmt = getConnect().prepareStatement(sql);
			rs = psmt.executeQuery(); // 쿼리실행.

			while (rs.next()) { // 조회된 결과가 있으면.
				MemberVO mvo = new MemberVO();
				mvo.setMemberId(rs.getString("member_id"));
				mvo.setPasswd(rs.getString("passwd"));
				mvo.setMemberName(rs.getString("member_name"));
				mvo.setResponsibility(rs.getString("responsbility"));

				list.add(mvo); // list컬렉션에 건수만큼 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public MemberVO login(String id, String pw) {
		String sql = "select member_id"//
				+ "         ,passwd"//
				+ "         ,member_name"//
				+ "         ,responsbility"//
				+ "   from tbl_member "//
				+ "   where member_id = ?"//
				+ "   and   passwd = ?";
		// 조회.
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery(); // 쿼리실행.

			if (rs.next()) { // 조회된 결과가 있으면.
				MemberVO mvo = new MemberVO();
				mvo.setMemberId(rs.getString("member_id"));
				mvo.setPasswd(rs.getString("passwd"));
				mvo.setMemberName(rs.getString("member_name"));
				mvo.setResponsibility(rs.getString("responsbility"));
				return mvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null; // 조회결과 없음.
	}
}
