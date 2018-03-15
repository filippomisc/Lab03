package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	private List<String> d = new LinkedList<>();
	private List<String> listP;
	private List<RichWord> rws;

	
	public Dictionary() {
		d.clear();
		listP = new LinkedList<>();
		rws = new LinkedList<>();

	}

	
	
	public List<RichWord> getRws() {
		return rws;
	}

	
	public void setRws(List<RichWord> rws) {
		this.rws = rws;
	}

	public void pulisciLista() {
		rws.clear();
	}
	
	public void loadDictionary (String Language) {
		//d.clear();
		try {
			
			FileReader fr = new FileReader("rsc/"+ Language +".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				d.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		for(String w : inputTextList) {
			RichWord rw = new RichWord(w);
			if(d.contains(w.toLowerCase())) {
				rw.setCor(true);
//				rws.add(rw);
			}else {
				//RichWord rw = new RichWord(w, false);
//				rws.add(rw);
				rw.setCor(false);
			}	
			rws.add(rw);
		}
 		return rws ;
	}

	public List<String> getD() {
		return d;
	}

	/**
	 * metodo che elimina i segni di punteggiatura
	 * @param frase
	 * @return lista di parole splittate
	 */
	public List<String> standardizzaStringa(String frase) {

	
		String strSenzaACapo = frase.replaceAll("\n", " ");
		
		String strSenzaPunt = strSenzaACapo.replaceAll("\\p{Punct}", "");
		//inserire 'a capo' replacell;
		
		// se abbiamo una punteggiatura tra 
	  	//due spazi, la considera come un oggetto 
		//della lista
		String strPulita = strSenzaPunt.replaceAll("  ", " ");// se abbiamo una punteggiatura tra 
											  	//due spazi, la considera come un oggetto 
											  //della lista
		
		String[] parole = strPulita.split(" ");
		
		for(String p : parole) {
			listP.add(p);
		}
		return listP;
//		frase = frase.replaceAll("\n", " ");
//		frase = frase.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
//		StringTokenizer st = new StringTokenizer(frase, " ");
//		while (st.hasMoreTokens()) {
//			listP.add(st.nextToken());
//			}
//		return listP;
	}
	
	public String StampaSpellCheker (List<RichWord> rws) {
		
		StringBuilder result = new StringBuilder();
		for(RichWord rw : rws) {
			result.append(rw + "\n");
			}
		return result.toString();
	}

	public int contErrors(List<RichWord> rws) {
		
		int numErr = 0;
		for(RichWord rw : rws) {
			if(!rw.isCor())
				numErr++;
		}
		return numErr;
		
	}
	
	
	
}
