package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean correct;
	
	
	public RichWord(String word) {
		super();
		this.word = word;
		this.correct = false;
	}


	public boolean isCorrect() {
		return correct;
	}


	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


	public String getWord() {
		return word;
	}

	
	
	

}
