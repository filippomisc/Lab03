package it.polito.tdp.spellchecker.model;

import java.util.*;

public class testDictionary {

	public static void main(String[] args) {

		
		Dictionary dModel = new Dictionary();
		
		List<String> result = dModel.standardizzaStringa("a. bitch\naabid ' stai?");
		System.out.println(result.toString());
		System.out.println("");
		
		
		
		dModel.loadDictionary("Italian");
		//System.out.println(dModel.getD()+"\n");
		
		
		
		
		List<RichWord> ris2 = dModel.spellCheckText(result);
		
		
		
		System.out.println(dModel.StampaSpellCheker(ris2));
		
		
		
		int err = dModel.contErrors(ris2);
		System.out.println("errori: " + err);
		System.out.println();
//		ris2.toString();
//		for(RichWord rw : ris2) {
//	System.out.println(rw.toString());
//	}
		
		//test .clear lista di RichWords
		System.out.println(dModel.getRws());
		dModel.pulisciLista(dModel.getRws());
		System.out.println(dModel.getRws());

	}

}
