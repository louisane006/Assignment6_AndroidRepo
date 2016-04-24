package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Invoice;
import za.ac.cput.assignment6.Repos.Impl.InvoiceRepoImpl;
import za.ac.cput.assignment6.Repos.InvoiceRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class InvoiceRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        InvoiceRepo repo = new InvoiceRepoImpl(this.getContext());
        // CREATE
        Invoice createEntity = new Invoice.Builder()
                .invoiceNum(1200)
                .amount(2000)
                .build();
        Invoice insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Invoice>invoice = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",invoice.size()>0);

        //READ ENTITY
        Invoice entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Invoice updateEntity = new Invoice.Builder()
                .invoiceNum(4500)
                .build();
        repo.update(updateEntity);
        Invoice newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",1200,newEntity.getInvoiceNum());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Invoice deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);
    }
}
