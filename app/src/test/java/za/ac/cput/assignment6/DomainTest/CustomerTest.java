package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerTest {

    Customer customer;
    Customer newCustomer;
    public CustomerTest() {
    }
    @Test
    public void createTest(){
        customer = new Customer.Builder("10000").idendtification("CI100").name("Sarah").surname("Smith").build();
        Assert.assertEquals(customer.getName() , "Sarah");
    }
    @Test
    public void updateTest() {
        newCustomer = new Customer.Builder("10000").name("Lorrie").build();
        Assert.assertEquals(newCustomer.getName(), "Lorrie");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
