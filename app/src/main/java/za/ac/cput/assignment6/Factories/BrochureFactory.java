package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface BrochureFactory {
        Brochure createBrochure(Designer design, String desc, String taskNumber, Customer customer, double price);
    }

