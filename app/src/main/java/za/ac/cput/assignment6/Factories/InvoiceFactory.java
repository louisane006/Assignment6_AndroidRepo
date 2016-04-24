package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Cashier;
import za.ac.cput.assignment6.Domain.Invoice;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class InvoiceFactory {
    public static Invoice inv(Long i, String identification, int n, Cashier c) {
        return new Invoice.Builder()
                .identification(i)
                .invoiceNum(n)
                .cashier(c)
                .build();

    }
}
