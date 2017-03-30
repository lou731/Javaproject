package carnetadresses.AccessDatas;

import carnetadresses.Models.Contact;
import java.util.*;

/**
 * 
 */
public interface IAccessData {

    /**
     * Get all contacts
     * @return list of all contacts
     */
    public ArrayList<Contact> GetContacts();
    
    /**
     * Search contacts
     * @param search, string to search in prenom or nom
     * @return List og found contacts
     */
    public ArrayList<Contact> GetContacts(String search);
    
    /**
     * Get a contact by id
     * @param id contact
     * @return contact found, null otherwise
     */
    public Contact GetContact(long id);

    /**
     * Remove contact by its id
     * @param id contact
     * @return true if removed, false if error occurs
     */
    public boolean SupressContact(long id);

    /**
     * Modify specified contact
     * @param contact to modify
     * @return true if success, false otherwise
     */
    public boolean ModifyContact(Contact contact);

    /**
     * Add new contact
     * @param contact to add
     * @return contact added with its id filled, null if error occurs
     */
    public Contact AddContact(Contact contact);

}