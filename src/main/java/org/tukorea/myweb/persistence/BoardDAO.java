package org.tukorea.myweb.persistence;

import java.util.List;

import org.tukorea.myweb.domain.BoardVO;

public interface BoardDAO {
	public void add(BoardVO board) throws Exception;
	public List<BoardVO> readListbyMovieId(String movieId) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void delete(int bno) throws Exception;
	public void update(BoardVO board) throws Exception;
	public List<BoardVO> readbyMovieId(String movieId) throws Exception;
}
