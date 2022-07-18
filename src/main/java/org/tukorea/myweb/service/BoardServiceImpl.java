package org.tukorea.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.myweb.domain.BoardVO;
import org.tukorea.myweb.persistence.BoardDAO;
 
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	public void addBoard(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.add(board);
	}

	public List<BoardVO> readBoardList(String movieId) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readListbyMovieId(movieId);
	}

	public BoardVO readBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.read(bno);
	}

	public void deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.delete(bno);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public float updateBoard(BoardVO board, String movieId) throws Exception {
		boardDAO.update(board);
		return calculateTotalScore(movieId);    //boardDAO.readbyrank(movierank)와 boardDAO.update(board) 트랜잭션 처리.
	}

	public float calculateTotalScore(String movieId) throws Exception {
		float sum=0;
		int i =0;
		List<BoardVO> boards = boardDAO.readbyMovieId(movieId);
		boards.size();
		for (BoardVO board : boards) {
			String score = board.getScore();
			float floatScore = Float.parseFloat(score);
			sum = sum +floatScore;
		}
		float avg = sum/ boards.size();
		
		return avg;
	}
}
