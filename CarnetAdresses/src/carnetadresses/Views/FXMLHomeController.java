/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import carnetadresses.Controllers.ControllerContact;
import carnetadresses.Models.Contact;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mamar
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private TableView tableView;
    @FXML
    private TableColumn cNom;
    @FXML
    private TableColumn cPrenom;
    @FXML
    private TableColumn cTel;
    @FXML
    private TableColumn cMail;
    
    private ControllerContact controller;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.cNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.cPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.cTel.setCellValueFactory(new PropertyValueFactory<>("tel1"));
        this.cMail.setCellValueFactory(new PropertyValueFactory<>("mail1"));
    }

    /**
     * Init controller with complete list of contact before shown windows
     * @param controller
     * @param contacts 
     */
    public void InitBeforeShown(ControllerContact controller, ObservableList<Contact> contacts)
    {
        this.controller = controller;
        this.tableView.setItems(contacts);
        this.tableView.setOnMouseClicked((MouseEvent me) -> {
            try {
                AddContactClicked(me);
            } catch (IOException ex) {
                Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    /**
     * Show new windows
     * @param e 
     * @throws java.io.IOException 
     */
    @FXML protected void AddContactClicked(MouseEvent e) throws IOException 
    {
        this.controller.AddContact(e);
    }
    
}
