package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Brand;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrandFactory {
    public static Brand brand(Customer cust, String d, Long i, String n, double p, Designer des) {
        return new Brand.Builder()
                .designer(des)
                .description(d)
                .id(i)
                .customer(cust)
                .price(p)
                .build();
    }
}