package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Repos.CustomerRepo;
import za.ac.cput.assignment6.Repos.Impl.CustomerRepoImpl;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerRepoTest extends AndroidTestCase {
    private static final String TAG = "SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CustomerRepo repo = new CustomerRepoImpl(this.getContext());
        // CREATE
        Customer createEntity = new Customer.Builder()
                .name("Emily")
                .surname("Smith")
                .custNum("200")
                .build();
        Customer insertedEntity = repo.save(createEntity);
        id = insertedEntity.getIdentification();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Customer> cust = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", cust.size() > 0);

        //READ ENTITY
        Customer entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Customer updateEntity = new Customer.Builder()
                .name("photos")
                .build();
        repo.update(updateEntity);
        Customer newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Emily", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Customer deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG + " DELETE", deletedEntity);

    }
}
