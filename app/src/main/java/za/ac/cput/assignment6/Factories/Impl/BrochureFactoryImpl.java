package za.ac.cput.assignment6.Factories.Impl;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Factories.BrochureFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrochureFactoryImpl implements BrochureFactory{

    private static BrochureFactoryImpl factory = null;

    private  BrochureFactoryImpl() {
    }
    public static BrochureFactoryImpl getInstance(){
        if(factory ==null)
            factory = new BrochureFactoryImpl();
        return factory;
    }
    public Brochure createBrochure(Designer designer, String desc, String taskNumber, Customer customer, double price) {
        Brochure brochure = new Brochure
                .Builder()
                .designer(designer)
                .customer(customer)
                .taskNum(taskNumber)
                .price(price)
                .build();
        return brochure;
    }
}
