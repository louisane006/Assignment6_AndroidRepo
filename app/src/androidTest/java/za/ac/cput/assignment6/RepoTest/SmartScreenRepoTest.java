package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.SmartScreen;
import za.ac.cput.assignment6.Repos.Impl.SmartScreenRepoImpl;
import za.ac.cput.assignment6.Repos.SmartScreenRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SmartScreenRepo repo = new SmartScreenRepoImpl(this.getContext());
        // CREATE
        SmartScreen createEntity = new SmartScreen.Builder()
                .name("Samsung")
                .code("BK500")
                .costPrice(5000.00)
                .build();
        SmartScreen insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<SmartScreen> screen = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",screen.size()>0);

        //READ ENTITY
        SmartScreen entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        SmartScreen updateEntity = new SmartScreen.Builder()
                .name("Accer")
                .build();
        repo.update(updateEntity);
        SmartScreen newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","BK500",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SmartScreen deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);

    }
}
