/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;
import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;

import java.net.URL;
import java.util.*;


import javafx.collections.FXCollections;
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
//	private List<String> listaParole = new LinkedList<>();

	
	
    @FXML//alla scelta della lingua
    void doActivate(ActionEvent event) {
		

    	
    	if(btnLanguage.getValue() != null) {
    		this.txtInsert.setDisable(false);
    		this.btnSC.setDisable(false);
    		this.txtResult.setDisable(false);
    		this.btnCT.setDisable(false);
    		this.txtInsert.clear();
    		this.txtResult.clear();
//    		this.model.loadDictionary(btnLanguage.getValue());
    	}else {
    		this.txtInsert.setDisable(true);
    		this.txtInsert.appendText("Inserire una lingua");
    		this.btnSC.setDisable(true);
    		this.txtResult.setDisable(true);
    		this.btnCT.setDisable(true);
    		this.lblErrors.setText("");
    		this.lblTime.setText("");
    	}
    	
    }

    @FXML
    void doClearText(ActionEvent event) {
		this.model.StampaSpellCheker(model.getRws());

    	txtInsert.clear();
		txtResult.clear();
		lblErrors.setText("");
		lblTime.setText("");
		
		
		

    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	String fraseIN = this.txtInsert.getText();

    	if(fraseIN.isEmpty()) {
    		txtResult.appendText("You must enter a phrase or word!");
    		txtInsert.clear();
    		return;
    	}
    	
    	this.model.loadDictionary(btnLanguage.getValue());
    	
    	List<RichWord> fraseRichOUT = model.spellCheckText(model.standardizzaStringa(fraseIN));
    	
    	String fraseOUT = model.StampaSpellCheker(fraseRichOUT);
    	txtResult.clear();
    	this.txtResult.setText(fraseOUT);
    	
    	
    	
    	
    	int err = this.model.contErrors(fraseRichOUT);
    	
    	this.lblErrors.setText("the text contains " + err + "errors");
    	
    	
    	
    	long start = System.nanoTime();
    	long end = System.nanoTime();
    	
    	this.lblTime.setText("Spell check completed in " + (end - start) / 1E9 + " seconds");
    	
    	
//    	
//    	int numErrori = 0;
//    	StringBuilder richText = new StringBuilder();
//    	List<RichWord> outputTextList;
//    	
//    	
//    	for(RichWord rw : outputTextList) {
//    	}	
    	
    	int numErr = model.contErrors(fraseRichOUT);
    	lblErrors.setText("The text contains " + numErr + " errors");
    	
    	
    	
    	
    
    	
    
    	
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
        
//       btnLanguage.setValue("English");
//       btnLanguage.setItems(FXCollections.observableArrayList("English", "Italian"));
        
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

		this.model = model;
}
}
