package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.SmartScreen;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenFactory {
    public static SmartScreen s(Long i, String n, String c, double p){
        return new SmartScreen.Builder()
                .id(i)
                .name(n)
                .code(c)
                .costPrice(p)
                .build();
    }
}
