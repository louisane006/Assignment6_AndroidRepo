package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrochureFactory {
    public static Brochure cashier(Customer cust, String d, Long i, String n, double p, Designer des) {
        return new Brochure.Builder()
                .designer(des)
                .desc(d)
                .id(i)
                .customer(cust)
                .price(p)
                .build();

    }
}