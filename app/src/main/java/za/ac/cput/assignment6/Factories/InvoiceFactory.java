package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Cashier;
import za.ac.cput.assignment6.Domain.Invoice;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface InvoiceFactory {
    Invoice createInvoice(String identification, int invoiceNum, Cashier cashier);
}
