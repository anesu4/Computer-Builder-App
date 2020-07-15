package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.stage.*;

public class CheckBuildController extends Controller<Build>{
    @FXML private Label textLbl;
    
    private final Build getBuild() {return model;}
    
    @FXML public void initialize(){
    String yeet = "";
        if(getBuild().isValid()) {
            yeet = "This build is functional.";
        } 
        else {
            if(getBuild().hasPartOfType("cpu") == false) {yeet = "The build is missing a CPU.\n";}
            if(getBuild().hasPartOfType("motherboard") == false) {yeet += "The build is missing a motherboard.\n";}
            if(getBuild().hasPartOfType("memory") == false) {yeet += "The build is missing RAM.\n";}
            if(getBuild().hasPartOfType("case") == false) {yeet += "The build is missing a case.\n";}
            if(getBuild().hasPartOfType("storage") == false) {yeet += "The build is missing storage.\n";}      
        }
    textLbl.setText(yeet);
    }  
    
    @FXML private void okayBtn(ActionEvent event){
        stage.close();
    }
}
