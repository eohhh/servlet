package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {

	public int insertReply(ReplyVO reply);
	public List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page);
<<<<<<< HEAD
	public List<ReplyVO> replyListAll(int boardNo);
	public List<Map<String, Object>> fullData();

	public int insertEvent(@Param("title") String title//
			, @Param("start") String start//
			, @Param("end") String end);
	
	public int insertEvent2(Map<String, String> map);
	
	// 삭제.
	public int deleteEvent(@Param("title") String title	//
			, @Param("start") String start	//
			, @Param("end") String end);
=======
	public int replyCount(int boardNo);
	public ReplyVO selectReply(int replyNo);
	public int deleteReply(int replyNo);
>>>>>>> branch 'master' of https://github.com/eohhh/servlet.git
}
