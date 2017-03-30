/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import javafx.scene.control.Alert;
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
//        alert.showAndWait();.ifPresent(rs -> {
//            if (rs == ButtonType.OK) {
//                System.out.println("Pressed OK.");
//            }
//        });
    }

    public static boolean ShowConfirmation(String message, String title)
    {
//        boolean ret = false;
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle(title);
//        //alert.setHeaderText("Look, an Information Dialog");
//        alert.setContentText(message);
//        alert.showAndWait().ifPresent((ButtonType rs) -> {
//            if (rs == ButtonType.OK) {
//                ret = true;
//            }
//        });
        
        return false;
    }    
}
