package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean correct;
	



	public RichWord(String word, boolean correct) {
		super();
		this.word = word;
		this.correct = correct;
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

	
	



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(word);
		return builder.toString();
	}
	

}
