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

public class ErrorController extends Controller<Catalogue>{
    @FXML private Button okayBtn;
    
    @FXML private void close(ActionEvent event){
        stage.close();
    }   
}
