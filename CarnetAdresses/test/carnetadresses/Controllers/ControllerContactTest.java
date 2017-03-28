/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Controllers;

import carnetadresses.Models.Contact;
import carnetadresses.AccessDatas.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mamar
 */
public class ControllerContactTest {
    
    private AccesData dt;
    
    public ControllerContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        Connection connection = DataBaseUtils.CreateDatabaseTest();
        this.dt = new AccesData(connection);
    }
    
    @After
    public void tearDown() 
    {
        this.dt = null;
    }

    /**
     * Test of CreateHomeForm method, of class ControllerContact.
     */
//    @Test
//    public void testCreateHomeForm() throws SQLException {
//        System.out.println("CreateHomeForm");
//        ControllerContact instance = new ControllerContact(this.dt);
//        instance.CreateHomeForm();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of CreateAddModifyForm method, of class ControllerContact.
//     */
//    @Test
//    public void testCreateAddModifyForm_Action() throws SQLException {
//        System.out.println("CreateAddModifyForm");
//        Action action = null;
//        ControllerContact instance = new ControllerContact();
//        instance.CreateAddModifyForm(action);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of CreateAddModifyForm method, of class ControllerContact.
//     */
//    @Test
//    public void testCreateAddModifyForm_Contact() throws SQLException {
//        System.out.println("CreateAddModifyForm");
//        Contact contact = null;
//        ControllerContact instance = new ControllerContact();
//        instance.CreateAddModifyForm(contact);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SuppressContact method, of class ControllerContact.
//     */
//    @Test
//    public void testSuppressContact() throws SQLException {
//        System.out.println("SuppressContact");
//        List<Integer> ids = null;
//        ControllerContact instance = new ControllerContact();
//        instance.SuppressContact(ids);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of AddContact method, of class ControllerContact.
     * @throws java.sql.SQLException
     */
    @Test
    public void testAddContact() throws SQLException {
        System.out.println("AddContact");
        Contact contact = null;
        ControllerContact instance = new ControllerContact(this.dt);
        instance.AddContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of ModifyContact method, of class ControllerContact.
//     */
//    @Test
//    public void testModifyContact() throws SQLException {
//        System.out.println("ModifyContact");
//        Contact contact = null;
//        ControllerContact instance = new ControllerContact();
//        instance.ModifyContact(contact);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of FilterContact method, of class ControllerContact.
//     */
//    @Test
//    public void testFilterContact() throws SQLException {
//        System.out.println("FilterContact");
//        ControllerContact instance = new ControllerContact();
//        instance.FilterContact();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
