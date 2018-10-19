/*
 * Name: Dattran
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package users_controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dattr
 */
public class UserBook_cTest {
    
    public UserBook_cTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRemain method, of class UserBook_c.
     */
    @Test
    public void testGetRemain() {
        System.out.println("getRemain");
        UserRegister_c instance = new UserRegister_c();
        String expResult = "1";
        String result = instance.getRemain();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class UserBook_c.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        String USERNAME = "";
        String namebook = "";
        UserRegister_c instance = new UserRegister_c();
        boolean expResult = false;
        boolean result = instance.check(USERNAME, namebook);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sendRegister method, of class UserBook_c.
     */
    @Test
    public void testSendRegister() {
        System.out.println("sendRegister");
        String username = "";
        String namebook = "";
        UserRegister_c instance = new UserRegister_c();
        instance.sendRegister(username, namebook);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fixStatus method, of class UserBook_c.
     */
    @Test
    public void testFixStatus() {
        System.out.println("fixStatus");
        String status = "";
        String namebook = "";
        UserRegister_c instance = new UserRegister_c();
        instance.fixStatus(status, namebook);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fixRemain method, of class UserBook_c.
     */
    @Test
    public void testFixRemain() {
        System.out.println("fixRemain");
        String username = "";
        UserRegister_c instance = new UserRegister_c();
        boolean expResult = false;
        boolean result = instance.fixRemain(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
