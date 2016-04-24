package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

import za.ac.cput.assignment6.Domain.Parts;
import za.ac.cput.assignment6.Domain.Shop;
import za.ac.cput.assignment6.Repos.Impl.ShopRepoImpl;
import za.ac.cput.assignment6.Repos.ShopRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopRepoTest extends AndroidTestCase {
    private static final String TAG = "SETTINGS TEST";
    private Long id;
    List<Parts> part;

    public void testCreateReadUpdateDelete() throws Exception {
        ShopRepo repo = new ShopRepoImpl(this.getContext());
        // CREATE
        Shop createEntity = new Shop.Builder()
                .address("406, Protea Place, Plumstead")
                .size(500.22)
                .part(part)
                .build();
        Shop insertedEntity = repo.save(createEntity);
        id = insertedEntity.getIdentification();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Shop> screen = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", screen.size() > 0);

        //READ ENTITY
        Shop entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Shop updateEntity = new Shop.Builder()
                .size(800.22)
                .build();
        repo.update(updateEntity);
        Shop newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", 500.22, newEntity.getSize());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Shop deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG + " DELETE", deletedEntity);

    }
}
