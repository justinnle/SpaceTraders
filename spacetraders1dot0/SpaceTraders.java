/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spacetraders1dot0.model.Player;
import spacetraders1dot0.model.Universe;

/**
 *
 * @author Justin
 */
public class SpaceTraders extends Application {

    public Stage primaryStage;
    public WelcomeScreenController welcomeScreenController;
    public Player player;
    public Universe universe;
  
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        player = new Player();
        universe = new Universe();
        universe.createUniverse();
        universe.displayUniverse();
        goToWelcome();
        stage.show();
    }
   
    public void goToWelcome(){
        try{
            WelcomeScreenController controller = (WelcomeScreenController) replaceSceneContent("view/WelcomeScreen.fxml");
            controller.setMainApp(this);
        }
        catch(Exception e){
            System.out.println("Could not load screen: " + e.getMessage());
        }
    }
    public void goToConfig(){
        try{
            ConfigurationScreenController controller = (ConfigurationScreenController) replaceSceneContent("view/ConfigurationScreen.fxml");
            controller.setMainApp(this);           
        }
        catch(Exception e){
            System.out.println("Could not load screen: " + e.getMessage());
        }
    }
    
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = getClass().getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        return (Initializable) loader.getController();
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
