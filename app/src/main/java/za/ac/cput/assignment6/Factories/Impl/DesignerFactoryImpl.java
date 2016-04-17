package za.ac.cput.assignment6.Factories.Impl;

import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Factories.DesignerFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class DesignerFactoryImpl implements DesignerFactory{

        private static DesignerFactoryImpl factory = null;

        private  DesignerFactoryImpl() {
    }
    public static DesignerFactoryImpl getInstance(){
        if(factory ==null)
            factory = new DesignerFactoryImpl();
        return factory;
    }
    public Designer createDesigner(String identification, String name, String surname, String taskNum) {
        Designer designer = new Designer
                    .Builder("1000")
                    .identification(identification)
                    .name(name)
                    .surname(surname)
                    .build();
        return designer;
    }
}
