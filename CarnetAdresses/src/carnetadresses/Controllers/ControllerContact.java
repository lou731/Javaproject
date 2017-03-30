package carnetadresses.Controllers;

import carnetadresses.AccessDatas.IAccessData;
import carnetadresses.AccessDatas.AccesData;
import carnetadresses.Models.Contact;
import carnetadresses.Views.Action;
import carnetadresses.Views.FXMLAddModiFyContactController;
import carnetadresses.Views.FXMLHomeController;
import carnetadresses.Views.UtilsView;
import java.io.IOException;
import java.net.URL;
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
     * The main stage of the applcation
     */
    private Stage mainStage;
    
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
    public ControllerContact(FXMLHomeController controllerHomeDoc, Stage mainStage) throws SQLException {
        this(new AccesData());
        this.controllerHomeDoc = controllerHomeDoc;
        this.mainStage = mainStage;
    }
        
    /**
     * Constructor used for testing
     * @param accessData
     */
    public ControllerContact(IAccessData accessData) {
        this.accessData = accessData;
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
     * @throws IOException 
     */
    public void AddContactForm() throws IOException
    {
        this.CreateDetailContactView(Action.Add, new Contact(), "Ajout d'un nouveau contact");        
    }
    
    /**
     * Modify existing contact.
     * @param contact
     * @throws java.lang.Exception
     */
    public void ModifyContactForm(Contact contact) throws Exception 
    {
        this.CreateDetailContactView(Action.Modify, contact, "Modification du contact : " + contact.getNom());        
    }

    /**
     * @param ids
     */
    public void SuppressContact(Contact contact) 
    {
        //UtilsView.ShowAlert(, message, title);
    }

    /**
     * Add contact in database and update local observable list
     * @param contact
     * @return 
     */
    public Contact AddContact(Contact contact) throws Exception 
    {
        Contact contactAdded = this.accessData.AddContact(contact);
        if(null != contactAdded)
        {
            this.contacts.add(contactAdded);
        }
        else
        {
            throw new Exception("Error occurs while saving contact.");
        }
        
        return contactAdded;
    }  
    
    /**
     * Modify existing contact.
     * @param contact
     * @throws java.lang.Exception
     */
    public void ModifyContact(Contact contact) throws Exception 
    {
        boolean correct = this.accessData.ModifyContact(contact);
        if(!correct)
        {
            throw new Exception("Error occurs while saving contact.");
        }
        else
        {
            int index = this.contacts.indexOf(contact);
            this.contacts.set(index, (Contact)contact.clone());
        }
    }
        
    /**
     * Create add or modify conatc form
     * @param action
     * @param contact
     * @param tilte
     * @throws IOException 
     */
    private void CreateDetailContactView(Action action, Contact contact, String tilte) throws IOException
    {
        URL location = FXMLAddModiFyContactController.class.getResource("FXMLAddModiFyContact.fxml");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        FXMLAddModiFyContactController controller = (FXMLAddModiFyContactController)fxmlLoader.getController();
        controller.InitBeforeShown(this, action, contact);
        stage.setScene(new Scene(root));
        stage.setTitle(tilte);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(this.mainStage);
        stage.showAndWait();
    }
}