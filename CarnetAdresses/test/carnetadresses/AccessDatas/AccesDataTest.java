/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.AccessDatas;

import carnetadresses.Models.Contact;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mamar
 */
public class AccesDataTest {
    
    private Connection connection;
    private AccesData instance;
   
    
    public AccesDataTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        this.connection = DataBaseUtils.CreateDatabaseTest();
        this.instance = new AccesData(this.connection);
        
        // creatre contact 1
        Contact contact = new Contact();
        contact.setNom("AAA");
        contact.setPrenom("ccccc");
        contact.setComplement("Batiment E");// il prend en compte avec ou sans accent circonflexe
        contact.setMail1("toto@gmail.com");
        
        this.instance.AddContact(contact);
        
        // Create contact 2
        contact = new Contact();
        contact.setNom("Toto");
        contact.setPrenom("Alexis");
        contact.setCp("31000");
        contact.setComplement("Bâtiment D");
        contact.setMail1("toto.aaaa@gmail.com");
        contact.setRue("Rue des lilas");
        
        this.instance.AddContact(contact);
        
        // Create contact 3
        contact = new Contact();
        contact.setNom("Martin");
        contact.setPrenom("aski");
        contact.setMail1("aaa@hotmail.com");
        contact.setMail2("bbb@gmail.com");
        
        this.instance.AddContact(contact);
        
        //Create contact 4
        contact = new Contact();
        contact.setNom("Zueras");
        contact.setPrenom("Alexis");
        contact.setRue("8, rue des Lilas");
        contact.setComplement("Batiment C"); 
        contact.setCp("32000"); 
        contact.setVille("Auch");
        contact.setMail1("gggg@gmail.com"); 
        contact.setTel1("0562487952");
        //contact.setTel2("06.56.42.10.25"); // Probleme sur le tel 2 avec les .
        
        
        this.instance.AddContact(contact);
        
        //Create contact 5
        contact = new Contact();
        contact.setNom("Titi");
        contact.setPrenom("aaaaa");
        
        this.instance.AddContact(contact);
        // et les autres champs sont à NULL
        
        //Create contact 6
        contact = new Contact();
        contact.setNom("Martine");
        contact.setPrenom("Alex");
        contact.setRue("185, rue des champs");
        contact.setVille("Toulouse");
        // et les autres champs sont à NULL
        
        this.instance.AddContact(contact);
        
        //Create contact 7
        contact = new Contact();
        contact.setNom("Poirot");
        contact.setPrenom("Hercule");
        contact.setCp(""); // ça affiche vide
        contact.setVille("Auch");
        
        this.instance.AddContact(contact);
        
        //Create contact 8
        contact = new Contact();
        contact.setNom("Marie");
        contact.setPrenom("toto");
        contact.setCp("31500");
        contact.setVille("ssss");
        
        this.instance.AddContact(contact);
        //Ce contact n'a pas été pris en compte ( ce contact n'existe pas )
    }
    
    @After
    public void tearDown() {
        this.connection = null;
    }

   /**
    * Test of GetContacts method, of class AccesData.
    */
   @Test
    public void testGetContacts(){
        System.out.println("GetContacts");
        ArrayList<Contact> ret =  instance.GetContacts();
        assertEquals(8, ret.size());
    }
    
       /**
    * Test of GetContact method, of class AccesData.
    */
   @Test
    public void testGetContact(){
        System.out.println("GetContacts");
        Contact ret =  instance.GetContact(8);
        assertNotNull(ret);
        assertEquals("Marie", ret.getNom());
    }

    /**
     * Test of SupressContact method, of class AccesData.
     */
   @Test
   public void testSupressContact() {
        System.out.println("SupressContact");
        ArrayList<Contact> ret = null;
        
        // suppress contact with id=8
        boolean suppr = instance.SupressContact(8);
        ret = instance.GetContacts();
        assertEquals(7, ret.size());
        assertTrue(suppr);
        assertNull(this.instance.GetContact(8));
        
        // Suppress inexisting contact
        instance.SupressContact(101); 
        assertEquals(7, this.instance.GetContacts().size());
    }
   
    /**
     * Test of ModifyContact method, of class AccesData.
     */
    @Test
    public void testModifyContact() {
        System.out.println("ModifyContact");        
        Contact ret = instance.GetContact(8);
        ret.setNom("aaaaaa");// on donne le nom dans la 8eme ligne
        assertTrue(instance.ModifyContact(ret));
        ret = this.instance.GetContact(8);
        assertEquals("aaaaaa", ret.getNom());
    }

    /**
     * Test of AddContact method, of class AccesData.
     */
    @Test
    public void testAddContact() {
        System.out.println("AddContact");
        Contact contact = new Contact();
        Contact ret = null;
        contact.setNom("Toto");
        contact.setPrenom("Titi");
        contact.setCp("31500");
        ret = instance.AddContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        
        assertEquals(9, ret.getId());
        assertEquals("Toto", ret.getNom());
        assertEquals("Titi", ret.getPrenom());
        assertEquals("31500", ret.getCp());
        assertEquals(9, this.instance.GetContacts().size());
    }
}
