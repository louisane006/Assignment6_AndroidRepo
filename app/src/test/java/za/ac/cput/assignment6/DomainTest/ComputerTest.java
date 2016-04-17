package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Computer;

/**
 * Created by louisane Malu on 3/29/2016.
 */
public class ComputerTest {
     Computer comp;
     Computer newComp;
    public ComputerTest() {
    }

    @Test
    public void createTest(){
        comp = new Computer.Builder().identification("213015889").name("Accer").code("42365").price(5000).build();
        Assert.assertEquals(comp.getName() , "Accer");
    }
    @Test
    public void updateTest() {
        newComp = new Computer.Builder().identification("213015889").name("HP").build();
        Assert.assertEquals(newComp.getName(), "HP");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
