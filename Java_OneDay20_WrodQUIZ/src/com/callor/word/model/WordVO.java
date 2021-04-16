package com.callor.word.model;

public class WordVO {

	private String kor;
	private String eng;
	private Integer score;
	
	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "WordVO [kor=" + kor + ", eng=" + eng + "]";
	}
	/**
	 * @return the kor
	 */
	public String getKor() {
		return kor;
	}
	/**
	 * @param kor the kor to set
	 */
	public void setKor(String kor) {
		this.kor = kor;
	}
	/**
	 * @return the eng
	 */
	public String getEng() {
		return eng;
	}
	/**
	 * @param eng the eng to set
	 */
	public void setEng(String eng) {
		this.eng = eng;
	}
	
	
	
}
