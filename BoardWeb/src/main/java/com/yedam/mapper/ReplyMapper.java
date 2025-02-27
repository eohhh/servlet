package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	
	public int insertReply(ReplyVO reply);
	public List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page);
	public int replyCount(int boardNo);
	public ReplyVO selectReply(int replyNo);
	public int deleteReply(int replyNo);
}
