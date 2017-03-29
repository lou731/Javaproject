package carnetadresses.Controllers;

import carnetadresses.AccessDatas.IAccessData;
import carnetadresses.AccessDatas.AccesData;
import carnetadresses.Models.Contact;
import carnetadresses.Views.Action;
import carnetadresses.Views.FXMLHomeController;
import java.sql.SQLException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;

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
    
    public void InitHomeController()
    {
        ArrayList<Contact> dataContacts = this.accessData.GetContacts();
        this.contacts = FXCollections.observableList(dataContacts);
        this.controllerHomeDoc.InitBeforeShown(this.contacts);
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