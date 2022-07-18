package org.tukorea.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.myweb.domain.BoardVO;
import org.tukorea.myweb.service.BoardService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private Date registerDate;
	private int boardnum;
	
	@Autowired
	private BoardService bs;
	
	
	//리스트 조회
	@RequestMapping(value = {"/list/movie{movieId}"}, method = RequestMethod.GET)
	public String getBoardList(@PathVariable String movieId, Model model) throws Exception {

		float totalScore = bs.calculateTotalScore(movieId);
		model.addAttribute("totalScore", totalScore);
		model.addAttribute("movieId", movieId);
		model.addAttribute("boards", bs.readBoardList(movieId));
		
		List<BoardVO> boardList = bs.readBoardList(movieId);
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}
		
		 return "board/board_list";
	}
	
	//게시판 등록
	@RequestMapping(value = {"/register/movie{movieId}"}, method = RequestMethod.GET)
	public String registerBoardGet(@PathVariable String movieId, Model model) throws Exception {

		 model.addAttribute("movieId", movieId);
		 return "board/board_register";
	}
	
	//게시판 등록
	@RequestMapping(value = {"/register/movie{movieId}"}, method = RequestMethod.POST)
	public String registerBoardPost(@PathVariable String movieId, @ModelAttribute("board") BoardVO vo) throws Exception {
		vo.setMovieID(movieId);
		bs.addBoard(vo);
		return "redirect:/board/list/movie"+movieId;
	}
	
	//게시판 삭제
	 @RequestMapping(value="/delete/movie{movieId}", method = RequestMethod.GET)
	    public String deleteBoardGet(@PathVariable String movieId, @RequestParam("bno") int bno) throws Exception {
	    	bs.deleteBoard(bno);
	    	return "redirect:/board/list/movie"+movieId;
	 }
	 
	 //게시판 수정
	 @RequestMapping(value = "/modify/movie{movieId}", method = RequestMethod.GET)
	    public String modifyBoardGet(@PathVariable String movieId, @RequestParam("bno") int bno, Model model) throws Exception {
	    	BoardVO board = bs.readBoard(bno);
		    boardnum = board.getBno();
		    model.addAttribute("movieId",movieId);
		    model.addAttribute("board", board);
		 
	        return "board/board_modify";
	    }
	 //게시판 수정  
     @RequestMapping(value = "/modify/movie{movieId}", method = RequestMethod.POST)
     public String modifyBoardPost(@ModelAttribute("board") BoardVO vo, @PathVariable String movieId) throws Exception {

		 vo.setBno(boardnum);
    	 bs.updateBoard(vo,movieId);
    	 
    	 return "redirect:/board/list/movie"+movieId;
	 }

}
