package org.tukorea.myweb.persistence;

import java.util.List;

import org.tukorea.myweb.domain.BoardVO;

public interface BoardDAO {
	public void add(BoardVO board) throws Exception;
	public List<BoardVO> readList() throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void delete(int bno) throws Exception;
	public void update(BoardVO board) throws Exception;
	public int totalscore(int movierank) throws Exception;
	public List<BoardVO> readbyrank(int movierank) throws Exception;
	public int countboard(int movierank) throws Exception;
}
