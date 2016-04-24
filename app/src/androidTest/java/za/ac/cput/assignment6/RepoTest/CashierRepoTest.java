package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Cashier;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Repos.CashierRepo;
import za.ac.cput.assignment6.Repos.Impl.CashierRepoImpl;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CashierRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;
    Customer cust;
    Designer des;

    public void testCreateReadUpdateDelete() throws Exception {
        CashierRepo repo = new CashierRepoImpl(this.getContext());
        // CREATE
        Cashier createEntity = new Cashier.Builder()
                .name("Karen")
                .surname("Smith")
                .taskNum("1000")
                .build();
        Cashier insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Cashier> cashier = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",cashier.size()>0);

        //READ ENTITY
        Cashier entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Cashier updateEntity = new Cashier.Builder()
                .surname("Thomas")
                .build();
        repo.update(updateEntity);
        Cashier newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Smith",newEntity.getSurname());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Cashier deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
