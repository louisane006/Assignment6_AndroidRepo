package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface CustomerFactory {
    Customer createCustomer(String identification, String custNum, String name, String surname);
}
