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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private Button bottonModify;
    @FXML
    private Button buttonSuppress;
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonDetail;    
    
    private ControllerContact controller;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.cNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.cPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.cTel.setCellValueFactory(new PropertyValueFactory<>("tel1"));
        this.cMail.setCellValueFactory(new PropertyValueFactory<>("mail1"));
        
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.tableView.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change c) -> {
            SelectionTablechanged(c);
        });
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
     * Add new contact button click
     * @param e 
     * @throws java.io.IOException 
     */
    @FXML protected void AddContactClicked(MouseEvent e) throws IOException 
    {
        try 
        {
            this.controller.AddContactForm();
        }
        catch (IOException iOException) 
        {
            UtilsView.ShowAlert(Alert.AlertType.ERROR, iOException.getMessage(), "Erreur sur ajout");
        }
    }
    
    /**
     * Modify contact button click
     * @param e 
     * @throws java.io.IOException 
     */
    @FXML protected void ModifyClicked(MouseEvent e) throws IOException, Exception 
    {
        try 
        {
            if (this.tableView.getSelectionModel().getSelectedItems().size() == 1) 
            {
                this.controller.ModifyContactForm((Contact) this.tableView.getSelectionModel().getSelectedItem());
            }
        } 
        catch (Exception exception) 
        {
            UtilsView.ShowAlert(Alert.AlertType.ERROR, exception.getMessage(), "Erreur sur modification");
        }
    }
    
    /**
     * Supress contact
     * @param e 
     * @throws java.io.IOException 
     */
    @FXML@SuppressWarnings("empty-statement") 
    protected void SuppressClicked(MouseEvent e) throws IOException 
    {
        try 
        {
            if (this.tableView.getSelectionModel().getSelectedItems().size() >= 1) 
            {
                if(UtilsView.ShowConfirmation("Voulez-vous vraiment supprimer les contacts sélectionnés", "Suppression de contacts", "Images/remove.jpg"))
                {
                    ArrayList<Contact> selectedItems = new ArrayList<>(this.tableView.getSelectionModel().getSelectedItems());
                    selectedItems.forEach((item) -> {
                        try 
                        {
                            this.controller.SuppressContact(item);
                        }
                        catch (Exception ex) 
                        {
                            UtilsView.ShowAlert(Alert.AlertType.ERROR, ex.getMessage(), "Erreur lors de la suppression");
                            Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        } 
        catch (Exception exception) 
        {
            UtilsView.ShowAlert(Alert.AlertType.ERROR, exception.getMessage(), "Erreur lors de la suppression");
        }
    }
        
    /**
     * Close application
     * @param e 
     */
    @FXML protected void DetailContactClicked(MouseEvent e)
    {
       try 
        {
            if (this.tableView.getSelectionModel().getSelectedItems().size() == 1) 
            {
                this.controller.DetailContactForm((Contact) this.tableView.getSelectionModel().getSelectedItem());
            }
        } 
        catch (IOException exception) 
        {
            UtilsView.ShowAlert(Alert.AlertType.ERROR, exception.getMessage(), "Erreur sur modification");
        }
    }
    
    /**
     * Select contact in grid 
     * @param c
     */
    @FXML protected void SelectionTablechanged(ListChangeListener.Change c)
    {
        int count = this.tableView.getSelectionModel().getSelectedItems().size();
        this.buttonSuppress.setDisable(count == 0);
        this.bottonModify.setDisable(count != 1);
        this.buttonDetail.setDisable(count != 1);
    }
        
    /**
     * Close application
     * @param e 
     */
    @FXML protected void CloseApplication(MouseEvent e)
    {
        Stage stage = (Stage) this.buttonClose.getScene().getWindow();
        stage.close();
    }
}
