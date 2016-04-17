package za.ac.cput.assignment6.Factories.Impl;

import java.util.List;

import za.ac.cput.assignment6.Domain.Parts;
import za.ac.cput.assignment6.Domain.Shop;
import za.ac.cput.assignment6.Factories.ShopFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopFactoryImpl implements ShopFactory{
    private static ShopFactoryImpl factory = null;

    private  ShopFactoryImpl() {
    }
    public static ShopFactoryImpl getInstance(){
        if(factory == null)
            factory = new ShopFactoryImpl();
        return factory;
    }
    public Shop createShop(String identification, double size, String address, List<Parts> part)
    {
        Shop shop = new Shop.Builder("406, Protea Place, Plumstead").size(size).build();
        return shop;
    }
}
