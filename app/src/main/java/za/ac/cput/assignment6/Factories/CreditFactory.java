package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Credit;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CreditFactory {
    public static Credit credit(Long id, double amt, String n){
        return new Credit.Builder()
                .identification(id)
                .amount(amt)
                .name(n)
                .build();
    }
}