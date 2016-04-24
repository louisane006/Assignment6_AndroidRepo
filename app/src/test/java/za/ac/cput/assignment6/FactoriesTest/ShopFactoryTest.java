package za.ac.cput.assignment6.FactoriesTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Domain.Shop;
import za.ac.cput.assignment6.Domain.VideoCamera;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopFactoryTest {
    Shop shop;
    Shop newShop;
    Laptop laptop;
    List<VideoCamera> camera;

    public ShopFactoryTest() {
    }
    @Test
    public void createTest(){
        shop = new Shop.Builder().identification((long) 55).size(500.22).address("406, Protea Place, Plumstead").build();
        Assert.assertEquals(shop.getSize() , 500.22);
    }
    @Test
    public void updateTest() {
        newShop = new Shop.Builder().size(800.20).build();
        Assert.assertEquals(newShop.getSize(), 800.20);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
