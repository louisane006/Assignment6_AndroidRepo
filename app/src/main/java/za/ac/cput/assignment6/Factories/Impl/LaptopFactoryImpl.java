package za.ac.cput.assignment6.Factories.Impl;

import java.util.UUID;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Factories.LaptopFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopFactoryImpl implements LaptopFactory {
    private static LaptopFactoryImpl factory = null;

    private  LaptopFactoryImpl() {
    }
    public static LaptopFactoryImpl getInstance(){
        if(factory == null)
            factory = new LaptopFactoryImpl();
        return factory;
    }
    public Laptop createLaptop(String identification, String name, String code, double price) {
        Laptop laptop = new Laptop.Builder().id(UUID.randomUUID().toString()).name(name).code(code).price(price).build();
        return laptop;
    }
}
