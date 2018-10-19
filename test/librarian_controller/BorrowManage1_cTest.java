/*
 * Name: Dattran
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package librarian_controller;

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
public class BorrowManage1_cTest {
    
    public BorrowManage1_cTest() {
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
     * Test of fixRemain method, of class BorrowManage1_c.
     */
    @Test
    public void testFixRemain() {
        System.out.println("fixRemain");
        String username = "";
        BorrowManage1_c instance = new BorrowManage1_c();
        instance.fixRemain(username);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
