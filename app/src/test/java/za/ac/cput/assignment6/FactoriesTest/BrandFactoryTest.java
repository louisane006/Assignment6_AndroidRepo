package za.ac.cput.assignment6.FactoriesTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Brand;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/23/2016.
 */
public class BrandFactoryTest {
    Brand frame;
    Brand newFrame;
    Designer designer;
    Customer customer;

    @Test
    public void createTest(){
        frame = new Brand.Builder().designer(designer).description("CI1000").id((long) 2000).customer(customer).build();
        junit.framework.Assert.assertEquals(frame.getCustomer() , customer);
    }
    @Test
    public void updateTest() {
        newFrame = new Brand.Builder().customer(customer).build();
        junit.framework.Assert.assertEquals(newFrame.getCustomer(), customer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
