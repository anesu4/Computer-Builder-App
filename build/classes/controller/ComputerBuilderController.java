package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.*;


public class ComputerBuilderController extends Controller<ComputerBuilder>{  
    private final ComputerBuilder getComputerBuilder(){return model;} //Run Model
    
    @FXML private void Catalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getComputerBuilder().getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage()); //Run Catalogue
    }
    
    @FXML private void Build(ActionEvent event) throws Exception{
        ViewLoader.showStage(getComputerBuilder(), "/view/build.fxml", "Current Build", new Stage()); //Run Build
    }

    @FXML private void Quit(ActionEvent event){ Platform.exit(); } //Exit All Windows
}