package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import model.*;
import au.edu.uts.ap.javafx.*;

public class BuildController extends Controller<Build>{
    @FXML private Button close;
    @FXML private Button checkBuild;
    @FXML private Button removeSelected;
    @FXML private Text totalTxt;
    @FXML private TableView<Part> buildTv;
    @FXML private TableColumn<Part, String> priceClm;
    
    @FXML private void initialize(){
        totalTxt.setText(String.format("%.2f", getBuild().totalPrice())); //Get Total Price and Format
        buildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //Multiple Select
        buildTv.getSelectionModel().selectedItemProperty().addListener((o,oldProduct,newProduct) 
                -> removeSelected.setDisable(newProduct == null)); //Disable button till listenner has selected Property
        
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f")); //Set price column to decimal point

        getBuild().getParts().addListener( new ListChangeListener() //Anonymous inner class
            { @Override
                public void onChanged(ListChangeListener.Change change) {
                    totalTxt.setText(String.format("%.2f", getBuild().totalPrice())); //Set totalTxt to text from totalPrice
                }
            }
        );
    }
    
    public final Build getBuild() { return model; } //Get Build model
    
    private ObservableList<Part> getPart(){ return buildTv.getSelectionModel().getSelectedItems();} //Get Part in Selection
    
    @FXML private void checkBuild(ActionEvent event) throws Exception {
    ViewLoader.showStage(getBuild(), "/view/buildcheck.fxml", "Build Validity Status", new Stage());} //New Stage
    
    @FXML private void removeSelected(ActionEvent event){ getBuild().remove(getPart());} //Remove Selected Part
   
    @FXML private void Close(ActionEvent event){ stage.close(); }
}
