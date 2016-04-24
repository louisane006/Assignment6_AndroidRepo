package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Manager;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerFactory {
    public static Manager man(Long i, String n, String snm, String t){
        return new Manager.Builder()
                .id(i)
                .name(n)
                .surname(snm)
                .taskNum(t)
                .build();
    }
}
