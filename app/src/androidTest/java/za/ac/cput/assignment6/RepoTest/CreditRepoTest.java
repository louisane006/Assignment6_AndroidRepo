package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Credit;
import za.ac.cput.assignment6.Repos.CreditRepo;
import za.ac.cput.assignment6.Repos.Impl.CreditRepoImpl;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CreditRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    long id;
    public void testCreateReadUpdateDelete() throws Exception {
        CreditRepo repo = new CreditRepoImpl(this.getContext());
        // CREATE
        Credit createEntity = new Credit.Builder()
                .name("cash")
                .amount(5000.00)
                .build();
        Credit insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Credit> credit = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",credit.size()>0);

        //READ ENTITY
        Credit entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Credit updateEntity = new Credit.Builder()
                .amount(7000.00)
                .build();
        repo.update(updateEntity);
        Credit newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",5000.00,newEntity.getAmount());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Credit deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);

    }
}
