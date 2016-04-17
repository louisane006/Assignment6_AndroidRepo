package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Manager;
import za.ac.cput.assignment6.Domain.Task;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerTest {
    Manager manager;
    Manager newManager;
    Task task;
    public ManagerTest() {
    }
    @Test
    public void createTest(){
        manager = new Manager.Builder("44500").id("2100").name("Jonathan").surname("Eddie").task(task).build();
        Assert.assertEquals(manager.getTaskNumber() , "44500");
    }
    @Test
    public void updateTest() {
        newManager = new Manager.Builder("5500B").task(task).build();
        Assert.assertEquals(newManager.getTaskNumber(), "5500B");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}

