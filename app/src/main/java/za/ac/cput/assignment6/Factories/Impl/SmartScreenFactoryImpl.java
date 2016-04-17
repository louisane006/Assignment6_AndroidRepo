package za.ac.cput.assignment6.Factories.Impl;

import java.util.UUID;

import za.ac.cput.assignment6.Domain.SmartScreen;
import za.ac.cput.assignment6.Factories.SmartScreenFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenFactoryImpl implements SmartScreenFactory {
    private static SmartScreenFactoryImpl factory = null;

    private  SmartScreenFactoryImpl() {
    }
    public static SmartScreenFactoryImpl getInstance(){
        if(factory == null)
            factory = new SmartScreenFactoryImpl();
        return factory;
    }
    public SmartScreen createSmartScreenFactory(String identification, String name, String code, double price)

    {
        SmartScreen screen = new SmartScreen.Builder().id(UUID.randomUUID().toString()).name(name).code(code).costPrice(price).build();
        return screen;
    }
}
