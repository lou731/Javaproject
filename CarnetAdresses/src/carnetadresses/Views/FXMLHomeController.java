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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField textSearch;
    
    private ControllerContact controller;
    private Contact selectedContact;
    
    
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
        
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Contact> filteredData = new FilteredList<>(contacts, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        this.textSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(contact -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                String nom = (contact.getNom() != null) ? contact.getNom().toLowerCase() : "";
                String prenom = (contact.getPrenom()!= null) ? contact.getPrenom().toLowerCase() : "";
                // Does not match.
                
                return nom.contains(lowerCaseFilter) || prenom.contains(lowerCaseFilter); 
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Contact> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(this.tableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        this.tableView.setItems(sortedData);
    }
    
    /**
     * Show new windows
     * @param e 
     * @throws java.io.IOException 
     */
    @FXML protected void AddContactClicked(MouseEvent e) throws IOException 
    {
        this.controller.AddContact(e);
        this.tableView.selectionModelProperty();
    }
    
    @FXML protected void SearchClicked()
    {
        
    }
    
    /**
     * Slect contact in grid
     * @param e 
     */
    @FXML protected void SelectionTablechanged(MouseEvent e)
    {
        Node node = ((Node) e.getTarget()).getParent();
        TableRow row;
        if (node instanceof TableRow) 
        {
            row = (TableRow) node;
        } else 
        {            
            // clicking on text part
            row = (TableRow) node.getParent();
        }
        
        if(null != row)
        {
            this.selectedContact = (Contact)row.getItem();
        }
        else
        {
            this.selectedContact = null;
        }
    }
}
