package za.ac.cput.assignment6.FactoriesTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Credit;

/**
 * Created by louisane Malu on 4/23/2016.
 */
public class CreditFactoryTest {
    Credit credit;
    Credit newCredit;
    @Test
    public void createTest(){
        credit = new Credit.Builder("10000").identification((long) 101010).amount(5000.00).build();
        Assert.assertEquals(credit.getAmount() , 5000.00);
    }
    @Test
    public void updateTest() {
        newCredit = new Credit.Builder("10000").amount(7000.00).build();
        Assert.assertEquals(newCredit.getAmount(), 7000.00);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
