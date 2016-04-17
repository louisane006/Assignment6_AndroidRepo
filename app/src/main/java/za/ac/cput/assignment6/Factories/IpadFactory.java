package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Ipad;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface IpadFactory {
    Ipad createIpad(String identification, String name, String code, double price);
}
