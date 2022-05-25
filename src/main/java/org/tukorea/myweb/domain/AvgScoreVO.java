package org.tukorea.myweb.domain;

import org.springframework.stereotype.Component;

@Component
public class AvgScoreVO {
	
	private int movierank;
	
	private float avgscore;

	public int getMovierank() {
		return movierank;
	}

	public void setMovierank(int movierank) {
		this.movierank = movierank;
	}

	public float getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(float avgscore) {
		this.avgscore = avgscore;
	}
	
}
