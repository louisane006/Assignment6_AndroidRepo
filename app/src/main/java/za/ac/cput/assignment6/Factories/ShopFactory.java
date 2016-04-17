package za.ac.cput.assignment6.Factories;

import java.util.List;

import za.ac.cput.assignment6.Domain.Parts;
import za.ac.cput.assignment6.Domain.Shop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface ShopFactory {
    Shop createShop(String identification, double size, String address, List<Parts> part);
}
