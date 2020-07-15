package controller;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.stage.*;

public class AddToCatalogueController extends Controller<Catalogue>{
    @FXML private Button addToCatalogueBtn;
    @FXML private TextField typeTf;
    @FXML private TextField priceTf;
    @FXML private TextField nameTf;

    public final Catalogue getCatalogue() {return model;}
    
    private double getPrice(){return Double.parseDouble(priceTf.getText());}
    private String getName() {return nameTf.getText();}
    private String getType() {return typeTf.getText();}

    @FXML private void addToCatalogue(ActionEvent event) throws Exception{
        try {
            if (getPrice() > 0.00){
            getCatalogue().addPart(getName(), getType(), getPrice());
            stage.close();
                    }
            else{
                ViewLoader.showStage(getCatalogue(), "/view/error.fxml", "Incorrect Input", new Stage());
            }
        }
        catch (Exception e) {
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        }
    }
}


