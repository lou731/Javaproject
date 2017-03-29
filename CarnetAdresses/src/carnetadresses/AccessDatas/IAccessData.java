package carnetadresses.AccessDatas;

import carnetadresses.Models.Contact;
import java.util.*;

/**
 * 
 */
public interface IAccessData {

    /**
     * récuperer liste contact
     * @return 
     */
    public ArrayList<Contact> GetContacts();
    
    /**
     * chercher un contact dont le nom et prenom est dans la chaine
     * @param search
     * @return 
     */
    public ArrayList<Contact> GetContacts(String search);
    
    /**
     * chercher un contact par son id
     * @param id
     * @return 
     */
    public Contact GetContact(long id);

    /**
     * supprime contact par son id
     * @param id
     * @return 
     */
    public boolean SupressContact(long id);

    /**
     * modifie contact
     * @param contact
     * @return 
     */
    public boolean ModifyContact(Contact contact);

    /**
     * ajoute contact et retourne contact mis a jour avec ID rempli
     * @param contact
     * @return 
     */
    public Contact AddContact(Contact contact);

}