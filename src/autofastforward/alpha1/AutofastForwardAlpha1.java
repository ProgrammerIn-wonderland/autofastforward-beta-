/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofastforward.alpha1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author niris
 */
public class AutofastForwardAlpha1 extends Application {

    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
            this.stage = stage; // initialize value of stage.
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Auto Fast Forward ->>");
        stage.getIcons().add(new Image(AutofastForwardAlpha1.class.getResourceAsStream("icon.png")));
        AutofastForwardAlpha1.stage.setResizable(false); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
