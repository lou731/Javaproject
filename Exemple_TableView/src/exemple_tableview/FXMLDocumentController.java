/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple_tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author Unkof
 */
public class FXMLDocumentController implements Initializable
    {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
        {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        }
    
    @FXML
    private TableView<Contact> maTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
        {
        // TODO
        }    
    
    }
