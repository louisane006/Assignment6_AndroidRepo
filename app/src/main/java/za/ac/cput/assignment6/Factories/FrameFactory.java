package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Domain.Frame;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface FrameFactory {
    Frame createFrame(Designer designer, String desc, String taskId, Customer customer);
}
