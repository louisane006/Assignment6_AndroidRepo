package za.ac.cput.assignment6.Factories.Impl;

import java.util.UUID;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Domain.Manager;
import za.ac.cput.assignment6.Domain.SmartScreen;
import za.ac.cput.assignment6.Domain.Task;
import za.ac.cput.assignment6.Factories.ManagerFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerFactoryImpl implements ManagerFactory {
    private static ManagerFactoryImpl factory = null;

    private  ManagerFactoryImpl() {
    }
    public static ManagerFactoryImpl getInstance(){
        if(factory == null)
            factory = new ManagerFactoryImpl();
        return factory;
    }
    public Manager createManager(String identification, String name, String surname, String taskNumber, Task task, SmartScreen screen, Laptop laptop)
    {
        Manager manager = new Manager.Builder("44500").id(UUID.randomUUID().toString()).name(name).surname(surname).task(task).build();
        return manager;
    }
}
