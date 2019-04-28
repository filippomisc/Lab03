/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;


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
		
    	
    }

    @FXML
    void doClearText(ActionEvent event) {
	

    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	
    
    	
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

		this.model = model;
}
}