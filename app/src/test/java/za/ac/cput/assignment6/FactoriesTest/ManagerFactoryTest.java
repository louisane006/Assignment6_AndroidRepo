package za.ac.cput.assignment6.FactoriesTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Manager;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerFactoryTest {
    Manager manager;
    Manager newManager;;
    public ManagerFactoryTest() {
    }
    @Test
    public void createTest(){
        manager = new Manager.Builder("44500").id((long) 2100).name("Jonathan").surname("Eddie").taskNum("1010").build();
        Assert.assertEquals(manager.getTaskNumber() , "44500");
    }
    @Test
    public void updateTest() {
        newManager = new Manager.Builder("5500B").taskNum("1010").build();
        Assert.assertEquals(newManager.getTaskNumber(), "5500B");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}

