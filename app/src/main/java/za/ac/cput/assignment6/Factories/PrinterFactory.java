package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Printer;
import za.ac.cput.assignment6.Domain.Prints;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface PrinterFactory {
    Printer createPrinter(String identification, String name, String taskId, Prints print);
}
