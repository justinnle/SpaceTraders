/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.io.IOException;
import java.net.URL;

import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.event.*;
import java.util.*;
import javafx.scene.layout.*;

/**
 *
 * @author Justin
 */
public class WelcomeScreenController extends AnchorPane implements Initializable {
    
    private SpaceTraders mainApp;
    
    @FXML
    private Label status;
    
    @FXML
    private Button newGame;
    
    @FXML
    private Button loadGame;
    
    public void setMainApp(SpaceTraders mainApp){
        this.mainApp = mainApp;
    }
    
    @FXML
    private void newGameHandler (ActionEvent event) throws IOException{
        status.setText("Starting new game...");
           /* Parent page = (Parent) FXMLLoader.load(getClass().getResource("view/ConfigurationScreen.fxml"));
            Scene scene = mainApp.primaryStage.getScene();
            if (scene == null) {
                scene = new Scene(page, 700, 450);
                //scene.getStylesheets().add(mainApp.class.getResource("demo.css").toExternalForm());
                mainApp.primaryStage.setScene(scene);
            } else {
                mainApp.primaryStage.getScene().setRoot(page);
            }
            mainApp.primaryStage.sizeToScene();*/
        mainApp.goToConfig();
    }
    
        
    @FXML
    private void loadGameHandler(ActionEvent event){
        status.setText(("Loading game..."));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
