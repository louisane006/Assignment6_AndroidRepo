package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Manager;
import za.ac.cput.assignment6.Repos.Impl.ManagerRepoImpl;
import za.ac.cput.assignment6.Repos.ManagerRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerRepoTest extends AndroidTestCase {
    private static final String TAG = "SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ManagerRepo repo = new ManagerRepoImpl(this.getContext());
        // CREATE
        Manager createEntity = new Manager.Builder()
                .name("Carin")
                .surname("Kirk")
                .taskNum("500")
                .build();
        Manager insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Manager> manager = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", manager.size() > 0);

        //READ ENTITY
        Manager entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Manager updateEntity = new Manager.Builder()
                .name("photos")
                .build();
        repo.update(updateEntity);
        Manager newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Kirk", newEntity.getSurname());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Manager deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG + " DELETE", deletedEntity);
    }
}

