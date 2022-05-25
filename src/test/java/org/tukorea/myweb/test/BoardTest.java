package org.tukorea.myweb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.myweb.domain.BoardVO;
import org.tukorea.myweb.service.BoardService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardTest {
	
	@Autowired
	private BoardService bs;
	
	//게시물 등록 테스트
	@Test
	public void testRegisterBoard() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("title");
		board.setContent("content");
		board.setScore("5");
		
		bs.addBoard(board);	
		System.out.print(board.getBno() + board.getContent() + board.getTitle() + board.getScore());
		int bno =board.getBno();
	}

	//게시물 리스트 조회 테스트
	@Test
	public void testModifyBoard() throws Exception{
		BoardVO board1 = new BoardVO();
		board1.setTitle("테스트 제목1");
		board1.setContent("테스트 내용1");
		board1.setScore("테스트 점수1");
		bs.addBoard(board1);
		
		BoardVO board2 = new BoardVO();
		board2.setTitle("테스트 제목2");
		board2.setContent("테스트 내용2");
		board2.setScore("테스트 점수2");
		bs.addBoard(board2);

		List<BoardVO> boardVOS = bs.readBoardList();
		for (BoardVO boardVO : boardVOS) {
			System.out.println("boardVO = " + boardVO.getTitle());
		}
	}
	
}
