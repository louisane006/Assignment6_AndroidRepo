package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Cashier;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CashierFactory {
        public static Cashier cashier(Long i, String n, String snm, String t){
                return new Cashier.Builder()
                        .identification(i)
                        .name(n)
                        .surname(snm)
                        .taskNum(t)
                        .build();
        }
}