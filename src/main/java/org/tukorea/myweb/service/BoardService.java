package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.BoardVO;

public interface BoardService {
	
	//게시판 등록
	public void addBoard(BoardVO board) throws Exception;
	//게시판 목록
	public List<BoardVO> readBoardList() throws Exception;
	//게시판 조회
	public BoardVO readBoard(int bno) throws Exception;
	//게시판 수정
	public float updateBoard(BoardVO board,String movieId) throws Exception;
	//게시판 삭제
	public void deleteBoard(int bno) throws Exception; 
	//총 평점 계산
	public float calculateTotalScore(String movierank) throws Exception;
	
}
