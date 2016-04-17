package za.ac.cput.assignment6.Factories.Impl;

import za.ac.cput.assignment6.Domain.Credit;
import za.ac.cput.assignment6.Factories.CreditFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CreditFactoryImpl implements CreditFactory {
    private static CreditFactoryImpl factory = null;

    private  CreditFactoryImpl() {
    }
    public static CreditFactoryImpl getInstance(){
        if(factory == null)
            factory = new CreditFactoryImpl();
        return factory;
    }
    public Credit createCredit( String identification, double amount, String name) {
        Credit credit = new Credit.Builder("10000").identification("1000").amount(5000.00).build();
        return credit;
    }
}
