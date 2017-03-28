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
    
    public AccesDataTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        this.connection = DataBaseUtils.CreateDatabaseTest();
    }
    
    @After
    public void tearDown() {
        this.connection = null;
    }

//    /**
//     * Test of GetContacts method, of class AccesData.
//     */
//    @Test
//    public void testGetContacts() {
//        System.out.println("GetContacts");
//        List<Contact> ret = null;
//        AccesData instance = new AccesData(this.connection);
//        ret = instance.GetContacts();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SupressContact method, of class AccesData.
//     */
//    @Test
//    public void testSupressContact() {
//        System.out.println("SupressContact");
//        int id = 0;
//        AccesData instance = new AccesData(this.connection);
//        instance.SupressContact(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ModifyContact method, of class AccesData.
//     */
//    @Test
//    public void testModifyContact() {
//        System.out.println("ModifyContact");
//        Contact contact = null;
//        AccesData instance = new AccesData(this.connection);
//        instance.ModifyContact(contact);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of AddContact method, of class AccesData.
     */
    @Test
    public void testAddContact() {
        System.out.println("AddContact");
        Contact contact = new Contact();
        Contact ret = null;
        AccesData instance = new AccesData(this.connection);
        contact.setNom("Toto");
        contact.setPrenom("Titi");
        contact.setCp("31500");
        ret = instance.AddContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        
        assertEquals(1, ret.getId());
        assertEquals("Toto", ret.getNom());
        assertEquals("Titi", ret.getPrenom());
        assertEquals("31500", ret.getCp());
        
        ArrayList<Contact> contacts = instance.GetContacts();
        assertEquals(1, contacts.size());
        
        contacts = instance.GetContacts("Tot");
        assertEquals(1, contacts.size());
        
        contacts = instance.GetContacts("it");
        assertEquals(1, contacts.size());
        
        ret.setNom("aaaaaa");
        assertTrue(instance.ModifyContact(ret));
        ret = instance.GetContact(1);
        assertEquals("aaaaaa", ret.getNom());
        
        instance.SupressContact(1);
        contacts = instance.GetContacts();
        assertEquals(0, contacts.size());
    }
}
