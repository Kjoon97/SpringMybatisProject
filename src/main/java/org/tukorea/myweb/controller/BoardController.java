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

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private Date registerDate;
	private int boardnum;
	private int rank;
	
	@Autowired
	private BoardService bs;
	
	//리스트 조회
	@RequestMapping(value = {"/list/movie{num}"}, method = RequestMethod.GET)
	public String getBoardList(@PathVariable int num, Model model) throws Exception {

		float totalScore = bs.calculateTotalScore(num);
		model.addAttribute("totalScore", totalScore);
		model.addAttribute("num", num);
		model.addAttribute("boards", bs.readBoardList());
		int num2=22;
		model.addAttribute("num2", num2);
		 return "board/board_list";
	}
	
	//게시판 등록
	@RequestMapping(value = {"/register/movie{num}"}, method = RequestMethod.GET)
	public String registerBoardGet(@PathVariable int num, Model model) throws Exception {

		 model.addAttribute("num", num);
		 return "board/board_register";
	}
	
	//게시판 등록
	@RequestMapping(value = {"/register/movie{num}"}, method = RequestMethod.POST)
	public String registerBoardPost(@PathVariable int num, @ModelAttribute("board") BoardVO vo) throws Exception {
		vo.setMovierank(num);
		bs.addBoard(vo);
		return "redirect:/board/list/movie"+num;
	}
	
	//게시판 삭제
	 @RequestMapping(value="/delete/movie{num}", method = RequestMethod.GET)
	    public String deleteBoardGet(@PathVariable int num, @RequestParam("bno") int bno) throws Exception {
	    	bs.deleteBoard(bno);
	    	return "redirect:/board/list/movie"+num;
	 }
	 
	 //게시판 수정
	 @RequestMapping(value = "/modify/movie{num}", method = RequestMethod.GET)
	    public String modifyBoardGet(@PathVariable int num, @RequestParam("bno") int bno, Model model) throws Exception {
	    	BoardVO board = bs.readBoard(bno);
		    boardnum = board.getBno();
		    rank = board.getMovierank();
		    model.addAttribute("num",num);
		    model.addAttribute("board", board);
		 
	        return "board/board_modify";
	    }
	 //게시판 수정  
     @RequestMapping(value = "/modify/movie{num}", method = RequestMethod.POST)
     public String modifyBoardPost(@ModelAttribute("board") BoardVO vo, @PathVariable int num) throws Exception {

		 vo.setBno(boardnum);
		 vo.setMovierank(rank);
    	 bs.updateBoard(vo,num);
    	 
    	 return "redirect:/board/list/movie"+num;
	 }

}
