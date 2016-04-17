package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.SmartScreen;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenTest {
    SmartScreen screen;
    SmartScreen newScreen;

    public SmartScreenTest() {
    }
    @Test
    public void createTest(){
        screen = new SmartScreen.Builder().id("102010120").name("Samsung").code("44500").costPrice(20000.00).build();
        Assert.assertEquals(screen.getName() , "Samsung");
    }
    @Test
    public void updateTest() {
        newScreen = new SmartScreen.Builder().name("LG").build();
        Assert.assertEquals(newScreen.getName(), "LG");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
