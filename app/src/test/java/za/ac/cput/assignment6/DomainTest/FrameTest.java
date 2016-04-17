package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Domain.Frame;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class FrameTest {

    Frame frame;
    Frame newFrame;
    Designer designer;
    Customer customer;
    public FrameTest() {
    }
    @Test
    public void createTest(){
        frame = new Frame.Builder().designer(designer).desc("CI1000").taskId("2000").customer(customer).build();
        Assert.assertEquals(frame.getCustomer() , customer);
    }
    @Test
    public void updateTest() {
        newFrame = new Frame.Builder().customer(customer).build();
        Assert.assertEquals(newFrame.getCustomer(), customer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}

