package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Ipad;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class IpadFactory {
    public static Ipad i(Long i, String n, String c, double p){
        return new Ipad.Builder()
                .id(i)
                .name(n)
                .code(c)
                .costPrice(p)
                .build();
    }
}
