package za.ac.cput.assignment6.Factories.Impl;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Printer;
import za.ac.cput.assignment6.Domain.Prints;
import za.ac.cput.assignment6.Factories.PrintsFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class PrintsFactoryImpl implements PrintsFactory {
    private static PrintsFactoryImpl factory = null;

    private  PrintsFactoryImpl() {
    }
    public static PrintsFactoryImpl getInstance(){
        if(factory == null)
            factory = new PrintsFactoryImpl();
        return factory;
    }
    public Prints createPrints(Printer printer, String desc, Customer customer, String taskId, double price)
     {
        Prints print = new Prints.Builder().printer(printer).desc(desc).customer(customer).taskId(taskId).price(price).build();
        return print;
    }
}
