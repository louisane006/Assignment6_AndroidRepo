package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class DesignerFactory {
    public static Designer des(Long i, String n, String snm, String t){
        return new Designer.Builder()
                .identification(i)
                .name(n)
                .surname(snm)
                .taskNumber(t)
                .build();
    }
}
