/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses;

import carnetadresses.Controllers.ControllerContact;
import carnetadresses.Views.FXMLHomeController;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent rootWindow = fxmlLoader.load();
        FXMLHomeController controllerHomeDoc = (FXMLHomeController)fxmlLoader.getController();
        ControllerContact controller = new ControllerContact(controllerHomeDoc, stage);

        // add windows shown event to init data before show the window
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent window) -> {
            controller.InitHomeController();
        });
        
        stage.setTitle("Carnet d'adresses");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Images/contact.png")));
        
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
