package za.ac.cput.assignment6.FactoriesTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Cashier;
import za.ac.cput.assignment6.Domain.Invoice;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class InvoiceFactoryTest {
    Invoice invoice;
    Invoice newInvoice;
    Cashier cashier;
    public InvoiceFactoryTest() {
    }
    @Test
    public void createTest(){
        invoice = new Invoice.Builder().identification((long) 41414141).invoiceNum(40500).cashier(cashier).amount(4500.00).build();
        Assert.assertEquals(invoice.getInvoiceNum() , 40500);
    }
    @Test
    public void updateTest() {
        newInvoice = new Invoice.Builder().invoiceNum(41500).build();
        Assert.assertEquals(newInvoice.getInvoiceNum(), 41500);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
