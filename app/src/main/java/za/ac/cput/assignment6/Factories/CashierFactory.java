package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Cashier;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface CashierFactory {
        Cashier createCashier(String identification, String name, String surname, String taskNumber);
        }
