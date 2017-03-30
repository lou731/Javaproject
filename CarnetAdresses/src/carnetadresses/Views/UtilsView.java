/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import carnetadresses.CarnetAdresses;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author mamar
 */
public class UtilsView 
{

    /**
     * Show an alert
     * @param type alert type
     * @param message message to display
     * @param title title of alert
     */
    public static void ShowAlert(Alert.AlertType type, String message, String title)
    {
        Alert alert = new Alert(type);
        //alert.setTitle("Message Here...");

        alert.setTitle(title);
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Show confirmation alert
     * @param message to display
     * @param title of alert
     * @param imagePath path of icon
     * @return true if ok click, false otherwise
     */
    public static boolean ShowConfirmation(String message, String title, String imagePath)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);

        if(!imagePath.isEmpty())
        {
            Image img = new Image(CarnetAdresses.class.getResourceAsStream(imagePath));
            Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(img);
        }
        
        Optional<ButtonType> result = alert.showAndWait();

        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }    
}
