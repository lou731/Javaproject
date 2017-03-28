package carnetadresses.AccessDatas;

import carnetadresses.Models.Contact;
import java.util.*;

/**
 * 
 */
public interface IAccessData {

    /**
     * @return 
     */
    public ArrayList<Contact> GetContacts();
    
    /**
     * @param search
     * @return 
     */
    public ArrayList<Contact> GetContacts(String search);
    
    /**
     * @param id
     * @return 
     */
    public Contact GetContact(long id);

    /**
     * @param id
     * @return 
     */
    public boolean SupressContact(long id);

    /**
     * @param contact
     * @return 
     */
    public boolean ModifyContact(Contact contact);

    /**
     * @param contact
     * @return 
     */
    public Contact AddContact(Contact contact);

}