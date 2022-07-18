package org.tukorea.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tukorea.myweb.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.myweb.mapper.BoardMapper";
	
	public void add(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insert", board);
	}


	public List<BoardVO> readList() throws Exception {
		// TODO Auto-generated method stub
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = sqlSession.selectList(namespace + ".selectAll");
		
		return boardlist;
	}


	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		BoardVO vo = sqlSession.selectOne(namespace+".selectByid", bno);
		return vo;  
	}


	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", bno);
	}


	public void update(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", board);
	}


	public int totalscore(String movieId) throws Exception {
		int totalscore = sqlSession.selectOne(namespace+ ".selectTotalScore", movieId);
		return totalscore;
	}


	public List<BoardVO> readbyMovieId(String movieId) throws Exception {
		// TODO Auto-generated method stub
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = sqlSession.selectList(namespace+ ".selectByMovieId", movieId);
		return boardlist;
	}

}
