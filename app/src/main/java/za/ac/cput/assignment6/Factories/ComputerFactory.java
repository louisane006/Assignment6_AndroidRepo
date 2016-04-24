package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Computer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ComputerFactory {

    public static Computer comp(Long id, String n, String c, double p){
        return new Computer.Builder()
                .identification(id)
                .code(c)
                .name(n)
                .price(p)
                .build();
    }
}
