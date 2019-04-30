/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnLanguage"
    private ComboBox<String> btnLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="txtInsert"
    private TextArea txtInsert; // Value injected by FXMLLoader

    @FXML // fx:id="btnSC"
    private Button btnSC; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnCT"
    private Button btnCT; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrors"
    private Label lblErrors; // Value injected by FXMLLoader

    @FXML // fx:id="lblTime"
    private Label lblTime; // Value injected by FXMLLoader

    
	private Dictionary model;

	private Integer count=0;
//	private List<String> listaParole = new LinkedList<>();

	
	
    @FXML//alla scelta della lingua
    void doActivate(ActionEvent event) {
    		if(btnLanguage.getValue()!=null) {

    			txtInsert.setDisable(false); 
    			txtInsert.clear();
    			btnSC.setDisable(false);




    			lblErrors.setText("");
    			lblTime.setText("");
    		
    		}
    	
    	
    }

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtInsert.clear();
    	this.txtResult.clear();
		txtResult.setDisable(true);
		btnCT.setDisable(true);


    	

    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	txtResult.clear();
    	
		try {
					List<String> parList = new ArrayList<>();
					
		    		model.riempiDizionario(btnLanguage.getValue());
		    		
		    		String input[]=txtInsert.getText().replaceAll("[.,||/#!?$%\\^&\\*;:{}=\\-_'()\\[\\]\"]", "").toLowerCase().split(" ");//TODO annotare per l'esame
					
		    		for (String parolaInput : input) {
						parList.add(parolaInput);
						
					}
					
		    		
		    		
					if(!parList.isEmpty()) {
						
		    			double start = System.nanoTime();
						Map<String, RichWord> result = model.spellCheckText(parList);
		    			double end = System.nanoTime();

						for (RichWord resErr : result.values()) {
							if(resErr.isCorrect()==false) {
								this.txtResult.appendText(resErr.getWord()+"\n");
								count++;
							}

							this.lblErrors.setText("the text contains " + count.toString() + " errors");
					    	this.lblTime.setText("Spell check copleted in "+(end-start)/(1000*1000) + " seconds");

						}
					}else {
						txtInsert.setText("Scrivere una frase");
					}
					
				} catch (IOException e) {
					txtResult.setText("scegliere una lingua");
					e.printStackTrace();
				}
		
		
		
		btnCT.setDisable(false);
    	txtResult.setDisable(false);

    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLanguage != null : "fx:id=\"btnLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSC != null : "fx:id=\"btnSC\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCT != null : "fx:id=\"btnCT\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrors != null : "fx:id=\"lblErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        

    }
    
    void setModel(Dictionary model) {

		txtInsert.setDisable(true);
		txtInsert.setText("Selezionare una lingua");

		txtResult.setDisable(true);
		btnLanguage.getItems().addAll("English", "Italian");

		btnSC.setDisable(true);
		btnCT.setDisable(true);

		lblErrors.setText("");
		lblTime.setText("");
		//TODO appuntarsi i metodi utili
		

		this.model = model;
}
}