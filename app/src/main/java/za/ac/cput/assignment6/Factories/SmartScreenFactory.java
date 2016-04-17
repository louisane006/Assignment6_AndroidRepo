package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.SmartScreen;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface SmartScreenFactory {
    SmartScreen createSmartScreenFactory(String identification, String name, String code, double price);
}
