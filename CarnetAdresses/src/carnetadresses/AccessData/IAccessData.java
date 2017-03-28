package carnetadresses.AccessData;

import carnetadresses.Models.Contact;
import java.util.*;

/**
 * 
 */
public interface IAccessData {

    /**
     * @param ret
     */
    public void GetContacts(List<Contact> ret);

    /**
     * @param id
     */
    public void SupressContact(int id);

    /**
     * @param contact
     */
    public void ModifyContact(Contact contact);

    /**
     * @param contact 
     * @param ret
     */
    public void AddContact(Contact contact, Contact ret);

}