/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import carnetadresses.Models.Contact;
import java.net.URL;
import java.util.ResourceBundle;
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
     * @param contacts 
     */
    public void InitBeforeShown(ObservableList<Contact> contacts)
    {
        this.tableView.setItems(contacts);
        this.tableView.setOnMouseClicked((MouseEvent me) -> {
            AddContactClicked();
        });
    }
    
    private Event OnAddContact;
    public void SetOnAddContact(ActionEvent value)
    {
        this.OnAddContact = value;
    }
    
    /**
     * Show new windows
     * @param event 
     */
    @FXML protected void AddContactClicked() 
    {
        
    }
    
}
