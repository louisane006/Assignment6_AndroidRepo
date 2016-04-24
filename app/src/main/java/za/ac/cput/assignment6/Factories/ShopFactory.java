package za.ac.cput.assignment6.Factories;

import java.util.List;

import za.ac.cput.assignment6.Domain.Parts;
import za.ac.cput.assignment6.Domain.Shop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopFactory {
    public static Shop shop(Long i, double n, String a, List<Parts> part){
        return new Shop.Builder()
                .identification(i)
                .size(n)
                .address(a)
                .part(part)
                .build();
    }
}
