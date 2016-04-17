package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Domain.Manager;
import za.ac.cput.assignment6.Domain.SmartScreen;
import za.ac.cput.assignment6.Domain.Task;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface ManagerFactory {
    Manager createManager(String identification, String name, String surname, String taskNumber, Task task, SmartScreen screen, Laptop laptop);
}
