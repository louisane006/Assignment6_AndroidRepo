package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface DesignerFactory {
    public Designer createDesigner(String identification, String name, String surname, String taskNum);
}
