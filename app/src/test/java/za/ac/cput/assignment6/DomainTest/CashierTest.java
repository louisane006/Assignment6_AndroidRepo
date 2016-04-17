package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Cashier;
import za.ac.cput.assignment6.Domain.Laptop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CashierTest {
    Cashier cashier;
    Cashier newCashier;
    Laptop laptop;
    public CashierTest() {
    }
    @Test
    public void createTest(){
        cashier = new Cashier.Builder("10000").identification("1000").name("Karen").surname("Thomas").build();
        Assert.assertEquals(cashier.getSurname() , "Thomas");
    }
    @Test
    public void updateTest() {
        newCashier = new Cashier.Builder("10000").surname("Smith").build();
        Assert.assertEquals(newCashier.getSurname(), "Smith");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
