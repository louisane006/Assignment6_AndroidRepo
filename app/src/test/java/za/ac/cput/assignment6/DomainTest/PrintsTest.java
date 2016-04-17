package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Printer;
import za.ac.cput.assignment6.Domain.Prints;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class PrintsTest {
    Prints print;
    Prints newPrint;
    Printer printer;
    Customer customer;

    public PrintsTest() {
    }
    @Test
    public void createTest(){
        print = new Prints.Builder().printer(printer).desc("Wedding Cards").customer(customer).taskId("101").price(100.00).build();
        Assert.assertEquals(print.getCustomer() , customer);
    }
    @Test
    public void updateTest() {
        newPrint = new Prints.Builder().customer(customer).build();
        Assert.assertEquals(newPrint.getCustomer(), customer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
