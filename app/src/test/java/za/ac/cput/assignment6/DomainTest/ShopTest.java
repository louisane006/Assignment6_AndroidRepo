package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import za.ac.cput.assignment6.Domain.VideoCamera;
import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Domain.Prints;
import za.ac.cput.assignment6.Domain.Shop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopTest {
    Shop shop;
    Shop newShop;
    Laptop laptop;
    List<VideoCamera> camera;
    Prints print;

    public ShopTest() {
    }
    @Test
    public void createTest(){
        shop = new Shop.Builder("406, Protea Place, Plumstead").size(500.22).build();
        Assert.assertEquals(shop.getAddress() , "406, Protea Place, Plumstead");
    }
    @Test
    public void updateTest() {
        newShop = new Shop.Builder("55, Long Street, Cape Town").build();
        Assert.assertEquals(newShop.getAddress(), "55, Long Street, Cape Town");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
