/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses;

import carnetadresses.Controllers.ControllerContact;
import carnetadresses.Views.FXMLHomeController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author mamar
 */
public class CarnetAdresses extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {       
        
        URL location = getClass().getResource("Views/FXMLHome.fxml");
        //ResourceBundle resources = ResourceBundle.getBundle("com.foo.example");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent rootWindow = fxmlLoader.load();
        FXMLHomeController controllerHomeDoc = (FXMLHomeController)fxmlLoader.getController();
        ControllerContact controller = new ControllerContact(controllerHomeDoc);

        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent window) -> {
            controller.InitHomeController();
        });
        
        Scene scene = new Scene(rootWindow);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        launch(args);
    }
    
}
