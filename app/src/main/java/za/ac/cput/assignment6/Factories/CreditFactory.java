package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Credit;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface CreditFactory {
    Credit createCredit(String identification, double amount, String name);
}
