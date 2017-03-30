/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mamar
 */
public class UtilsView 
{

    /**
     * Show an alert
     * @param type
     * @param message
     * @param title 
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
     * @param message
     * @param title
     * @return 
     */
    public static boolean ShowConfirmation(String message, String title)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();

        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }    
}
