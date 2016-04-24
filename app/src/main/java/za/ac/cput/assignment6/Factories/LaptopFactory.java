package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Laptop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopFactory {
    public static Laptop l(Long i, String n, String c, double p){
        return new Laptop.Builder()
                .id(i)
                .name(n)
                .code(c)
                .price(p)
                .build();
    }
}
