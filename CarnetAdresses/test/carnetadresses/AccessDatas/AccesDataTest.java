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
import java.util.List;
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
        contact.setNom(null);
        contact.setPrenom(null);
        contact.setCp(null);
        contact.setVille(null);
        
        this.instance.AddContact(contact);
        //Ce contact n'a pas été pris en compte ( ce contact n'existe pas )
    }
    
    @After
    public void tearDown() {
        this.connection = null;
    }

//    /**
//     * Test of GetContacts method, of class AccesData.
//     */
   @Test
    public void testGetContacts(){
        System.out.println("GetContacts");
        ArrayList<Contact> ret = null;
        ret =  instance.GetContacts();
        assertEquals(7, ret.size());

    }
//
//    /**
//     * Test of SupressContact method, of class AccesData.
//     */
   @Test
   public void testSupressContact() {
        System.out.println("SupressContact");
        ArrayList<Contact> ret = null;
        boolean suppr = instance.SupressContact(8);
        ret = instance.GetContacts();
        assertEquals(7, ret.size());
        assertTrue(suppr);
        boolean suppr2 = instance.SupressContact(8);
        assertFalse(suppr2);
    }
//
//    /**
//     * Test of ModifyContact method, of class AccesData.
//     */
    @Test
    public void testModifyContact() {
        System.out.println("ModifyContact");
        Contact contact = null;// initialisation de la variable contact à null
        Contact ret = null; // initialisation de la variable ret à null
        //this.instance = new AccesData(this.connection);
        boolean res = instance.ModifyContact(contact);
        assertTrue(instance.ModifyContact(ret));
        ret = instance.GetContact(8);
        assertEquals("aaaaaa", ret.getNom());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of AddContact method, of class AccesData.
     */
    @Test
    public void testAddContact() {
        System.out.println("AddContact");
        Contact contact = new Contact();
        Contact ret = null;
       // AccesData instance = new AccesData(this.connection);
        contact.setNom("Toto");
        contact.setPrenom("Titi");
        contact.setCp("31500");
        ret = instance.AddContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        
        assertEquals(8, ret.getId());
        assertEquals("Toto", ret.getNom());
        assertEquals("Titi", ret.getPrenom());
        assertEquals("31500", ret.getCp());

        /*ArrayList<Contact> contacts = instance.GetContacts();
        assertEquals(8, contacts.size());
        
        contacts = instance.GetContacts("Tot");
        assertEquals(2, contacts.size());
        
        contacts = instance.GetContacts("it");
        assertEquals(2, contacts.size());
        
        ret.setNom("aaaaaa");
        assertTrue(instance.ModifyContact(ret));
        ret = instance.GetContact(8);
        assertEquals("aaaaaa", ret.getNom());
        
        instance.SupressContact(8);
        contacts = instance.GetContacts();
        assertEquals(7, contacts.size());*/
    }
}
