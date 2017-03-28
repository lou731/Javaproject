package carnetadresses.Controllers;

import carnetadresses.AccessDatas.IAccessData;
import carnetadresses.AccessDatas.AccesData;
import carnetadresses.Models.Contact;
import carnetadresses.Views.Action;
import carnetadresses.Views.HomeForm;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class ControllerContact {

    private IAccessData accessData;
    
    /**
     * 
     */
    private HomeForm mainForm;
    
    /**
     * Default constructor
     * @throws java.sql.SQLException
     */
    public ControllerContact() throws SQLException {
        this(new AccesData());
    }
    
    /**
     * Default constructor
     * @param accessData
     */
    public ControllerContact(IAccessData accessData) {
        this.accessData = accessData;
    }

    /**
     * 
     */
    public void CreateHomeForm() {
        // TODO implement here
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