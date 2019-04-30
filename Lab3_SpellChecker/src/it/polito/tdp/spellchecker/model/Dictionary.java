package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	private Map<String , String> dizionario;

	public Dictionary() {
		this.dizionario=new HashMap<>();
	}
	
	public Map<String, RichWord> spellCheckText(List<String> parole) {
		Map<String, RichWord> richWords = new HashMap<>();
		
		
		for (String p : parole) {
			if(dizionario.containsKey(p)) {
				richWords.put(p, new RichWord(p,true));
			}else {
				richWords.put(p, new RichWord(p,false));
			}
				
			
		}
		
		
		return richWords;
	}
	
	public void riempiDizionario(String Language) throws IOException {//Language puo essere English o Italian
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader("rsc/"+Language+".txt"));
			String word;
			while ((word = in.readLine()) != null){
				this.dizionario.put(word, word);
			
			}
			in.close();
			} catch (IOException e) {
				System.out.println("errore nella lettura del file");		
				}
		}
	}
