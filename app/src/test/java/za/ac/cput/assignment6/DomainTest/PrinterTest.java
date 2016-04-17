package za.ac.cput.assignment6.DomainTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Domain.Printer;
import za.ac.cput.assignment6.Domain.Prints;
import za.ac.cput.assignment6.Domain.VideoCamera;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class PrinterTest {
    Printer printer;
    Printer newPrinter;
    Laptop laptop;
    List<VideoCamera> camera;
    Prints print;

    public PrinterTest() {
    }
    @Test
    public void createTest(){
        printer = new Printer.Builder().name("Konita Minota").prints(print).build();
        Assert.assertEquals(printer.getName() , "Konita Minota");
    }
    @Test
    public void updateTest() {
        newPrinter = new Printer.Builder().name("Kodak 400").build();
        Assert.assertEquals(newPrinter.getName(), "Kodak 400");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
