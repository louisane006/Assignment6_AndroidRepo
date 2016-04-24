package za.ac.cput.assignment6.FactoriesTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class DesignerFactoryTest {
   Designer designer;
    Designer newDesigner;
    public DesignerFactoryTest() {
    }
    @Test
    public void createTest(){
        designer = new Designer.Builder().identification((long) 213015889).name("Louise").surname("Malu").build();
        Assert.assertEquals(designer.getName() , "Louise");
    }
    @Test
    public void updateTest() {
        newDesigner = new Designer.Builder("10000").name("Emily").build();
        Assert.assertEquals(newDesigner.getName(), "Emily");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
