package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerFactory {
    public static Customer cust(Long id, String num, String name, String surname){
        return new Customer.Builder()
                .identification(id)
                .custNum(num)
                .name(name)
                .surname(surname)
                .build();
    }
}
