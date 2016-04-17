package za.ac.cput.assignment6.Factories.Impl;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Factories.CustomerFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerFactoryImpl implements CustomerFactory {
    private static CustomerFactoryImpl factory = null;

    private  CustomerFactoryImpl() {
    }
    public static CustomerFactoryImpl getInstance(){
        if(factory == null)
            factory = new CustomerFactoryImpl();
        return factory;
    }
    public Customer createCustomer(String identification, String custNum, String name, String surname) {
        Customer customer = new Customer.Builder("10000").idendtification("CI100").name("Sarah").surname("Smith").build();
        return customer;
    }
}
