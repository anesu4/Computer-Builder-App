package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;

public class CatalogueController extends Controller<Catalogue> {
    @FXML private Button addSelectToBuild;
    @FXML private Button addPartTo;
    @FXML private Button removeSelectedFromCatalogue;
    @FXML private TextField typeTf;
    @FXML private TextField priceLowTf;
    @FXML private TextField priceHighTf;
    @FXML private TableView<Part> catalogueTv;
    @FXML private TableColumn<Part, String> typeCm;
    @FXML private TableColumn<Part, String> priceCm;
    
    @FXML private void initialize(){
        catalogueTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //select multiple
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((o,oldProduct,newProduct) 
                -> addSelectToBuild.setDisable(newProduct == null)); //set button to false
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((o,oldProduct,newProduct) 
                -> removeSelectedFromCatalogue.setDisable(newProduct == null)); //set button to false
        typeCm.setCellValueFactory(cellData -> cellData.getValue().typeProperty()); //Cell data for toUpperCase() on Type
        priceCm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%2.2f")); //Cell Data for decimal points
        
        typeTf.textProperty().addListener((o, old, newP) ->
            getCatalogue().filterList(getType(), getLow(), getHigh())); //Add Listerner to Type field
        priceLowTf.textProperty().addListener((o, old, newP) ->
            getCatalogue().filterList(getType(), getLow(), getHigh())); //Add Listerner to PriceLow field
        priceHighTf.textProperty().addListener((o, old, newP) ->
            getCatalogue().filterList(getType(), getLow(), getHigh())); //Add Listerner to PriceHigh field
    }
    
    public final Catalogue getCatalogue() { return model; } //Get Model
    
    private ObservableList<Part> getPart() {
        return catalogueTv.getSelectionModel().getSelectedItems(); //Get Part that is Selected
    }
    
    private String getHigh(){return priceHighTf.getText();} //Gets Low number
    private String getLow() {return priceLowTf.getText();} //Gets High Number
    private String getType() {return typeTf.getText();} //Gets Type
    
    @FXML private void addSelectToBuild(ActionEvent event){getCatalogue().addToBuild(getPart());} //Add Part to build list
    
    @FXML private void addPartTo(ActionEvent event) throws Exception{
        ViewLoader.showStage(getCatalogue(), "/view/addtocatalogue.fxml", "Add New Part To Catalogue", new Stage()); //Open new Stage
    }
    
    @FXML private void removeSelectedFromCatalogue(ActionEvent event){getCatalogue().remove(getPart());} //remove Selected Part
    
    @FXML private void Close(ActionEvent event){ stage.close();} //Close Stage
}