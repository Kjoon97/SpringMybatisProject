package org.tukorea.myweb.domain;

import java.util.Date;

public class BoardVO {

	//게시판 번호
	private int bno;
	
	//게시판 제목
	private String title;
	
	//게시판 내용
	private String content;
	
	//영화 평점
	private String score;
	
	//등록 날짜
	private Date regdate;
	
	//영화 아이디
	private String movieId;
	
	public String getMovieId() {
		return movieId;
	}

	public void setMovieID(String movieId) {
		this.movieId = movieId;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", score=" + score + ", regdate=" + regdate + ", movieId=" + movieId + "]";
	}
	
}
