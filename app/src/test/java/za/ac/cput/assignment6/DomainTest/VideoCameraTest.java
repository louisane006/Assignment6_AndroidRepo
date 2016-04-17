package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import za.ac.cput.assignment6.Domain.VideoCamera;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class VideoCameraTest {
    VideoCamera vc;
    VideoCamera newVc;

    public VideoCameraTest() {
    }
    @Test
    public void createTest(){
        vc = new VideoCamera.Builder().id("KDK100").name("Kodak").code("100").costPrice(8500.00).build();
        Assert.assertEquals(vc.getCode() , "100");
    }
    @Test
    public void updateTest() {
        newVc = new VideoCamera.Builder().code("100").build();
        Assert.assertEquals(newVc.getCode(), "100");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
