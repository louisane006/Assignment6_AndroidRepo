package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Designer;
import za.ac.cput.assignment6.Repos.DesignerRepo;
import za.ac.cput.assignment6.Repos.Impl.DesignerRepoImpl;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class DesignerRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        DesignerRepo repo = new DesignerRepoImpl(this.getContext());
        // CREATE
        Designer createEntity = new Designer.Builder()
                .name("Samsung")
                .surname("Malu")
                .taskNumber("5000")
                .build();
        Designer insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Designer> designer = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",designer.size()>0);

        //READ ENTITY
        Designer entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Designer updateEntity = new Designer.Builder()
                .name("Emily")
                .build();
        repo.update(updateEntity);
        Designer newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Samsung",newEntity.getName());

        /*// DELETE ENTITY
        repo.delete(updateEntity);
        Designer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);*/

    }
}
