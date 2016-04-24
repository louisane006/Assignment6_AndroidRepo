package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Laptop;
import za.ac.cput.assignment6.Repos.Impl.LaptopRepoImpl;
import za.ac.cput.assignment6.Repos.LaptopRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        LaptopRepo repo = new LaptopRepoImpl(this.getContext());
        // CREATE
        Laptop createEntity = new Laptop.Builder()
                .name("Lenovo")
                .code("44500")
                .price(500)
                .build();
        Laptop insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Laptop> laptop = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",laptop.size()>0);

        //READ ENTITY
        Laptop entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Laptop updateEntity = new Laptop.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        Laptop newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","44500",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Laptop deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);

    }
}

