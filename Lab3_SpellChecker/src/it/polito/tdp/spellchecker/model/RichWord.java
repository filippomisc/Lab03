package it.polito.tdp.spellchecker.model;

public class RichWord {

	private String word;
	private boolean cor ;
//	private int numErr;
	


	public RichWord(String word, boolean cor) {
		this.word = word;
		this.cor = false;
//		numErr = 0;
	}

	public RichWord(String word) {
		this.word = word;	
		}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return word + " (" + cor + ")";
	}
	
//	public int contErrors() {
//		return 0;
//	}
	
	

	
	
}
