package za.ac.cput.assignment6.Factories.Impl;

import java.util.UUID;

import za.ac.cput.assignment6.Domain.Ipad;
import za.ac.cput.assignment6.Factories.IpadFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class IpadFactoryImpl implements IpadFactory {
    private static IpadFactoryImpl factory = null;

    private  IpadFactoryImpl() {
    }
    public static IpadFactoryImpl getInstance(){
        if(factory == null)
            factory = new IpadFactoryImpl();
        return factory;
    }
    public Ipad createIpad(String identification, String name, String code, double price)
    {
        Ipad ipad = new Ipad.Builder().id(UUID.randomUUID().toString()).code(code).name(name).costPrice(price).build();
        return ipad;
    }
}
