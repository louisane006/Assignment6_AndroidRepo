package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Laptop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface LaptopFactory {
    Laptop createLaptop(String identification, String name, String code, double price);
}
