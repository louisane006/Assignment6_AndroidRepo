package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Ipad;
import za.ac.cput.assignment6.Repos.Impl.IpadRepoImpl;
import za.ac.cput.assignment6.Repos.IpadRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class IpadRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        IpadRepo repo = new IpadRepoImpl(this.getContext());
        // CREATE
        Ipad createEntity = new Ipad.Builder()
                .name("IpadeI600")
                .code("BK500")
                .costPrice(95000)
                .build();
        Ipad insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Ipad> ipdad = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",ipdad.size()>0);

        //READ ENTITY
        Ipad entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Ipad updateEntity = new Ipad.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        Ipad newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","BK500",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Ipad deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);

    }
}
