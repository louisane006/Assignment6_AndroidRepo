package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/2/2016.
 */
//@Embeddable
public interface Payment extends Serializable {
    String paymentType();
    double costForEverything();
}