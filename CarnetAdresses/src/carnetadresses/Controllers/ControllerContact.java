package carnetadresses.Controllers;

import carnetadresses.AccessDatas.IAccessData;
import carnetadresses.AccessDatas.AccesData;
import carnetadresses.Models.Contact;
import carnetadresses.Views.Action;
import carnetadresses.Views.FXMLAddModiFyContactController;
import carnetadresses.Views.FXMLHomeController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 */
public class ControllerContact {
    
    /**
     * Home controller windows
     */
    private FXMLHomeController controllerHomeDoc;
    
    /**
     * Access data layer
     */
    private IAccessData accessData;
    
    /**
     * Observable list used to display contacts
     */
    private ObservableList<Contact> contacts;
    
    /**
     * Default constructor use for application
     * @param controllerHomeDoc
     * @throws java.sql.SQLException
     */
    public ControllerContact(FXMLHomeController controllerHomeDoc) throws SQLException {
        this(new AccesData());
        this.controllerHomeDoc = controllerHomeDoc;
    }
    
    /**
     * Initialize the home controller form with data
     */
    public void InitHomeController()
    {
        ArrayList<Contact> dataContacts = this.accessData.GetContacts();
        this.contacts = FXCollections.observableList(dataContacts);
        this.controllerHomeDoc.InitBeforeShown(this, this.contacts);
    }
    
    /**
     * Add new contact show the new windows 
     * @param event
     * @throws IOException 
     */
    public void AddContact(Event event) throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(FXMLAddModiFyContactController.class.getResource("FXMLAddModiFyContact.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Ajout d'un nouveau contact");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.showAndWait();
    }
    
    /**
     * Constructor used for testing
     * @param accessData
     */
    public ControllerContact(IAccessData accessData) {
        this.accessData = accessData;
    }

    /**
     * @param action
     */
    public void CreateAddModifyForm(Action action) {
        // TODO implement here
    }

    /**
     * @param contact
     */
    public void CreateAddModifyForm(Contact contact) {
        // TODO implement here
    }

    /**
     * @param ids
     */
    public void SuppressContact(List<Integer> ids) {
        // TODO implement here
    }

    /**
     * @param contact
     */
    public void AddContact(Contact contact) {
        // TODO implement here
    }

    /**
     * @param contact
     */
    public void ModifyContact(Contact contact) {
        // TODO implement here
    }

    /**
     * 
     */
    public void FilterContact() {
        // TODO implement here
    }

}