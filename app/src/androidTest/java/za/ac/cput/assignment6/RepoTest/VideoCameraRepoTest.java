package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import za.ac.cput.assignment6.Domain.VideoCamera;
import za.ac.cput.assignment6.Repos.Impl.VideoCameraRepoImpl;
import za.ac.cput.assignment6.Repos.VideoCameraRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class VideoCameraRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        VideoCameraRepo repo = new VideoCameraRepoImpl(this.getContext());
        // CREATE
        VideoCamera createEntity = new VideoCamera.Builder()
                .name("Accer")
                .code("MK400")
                .costPrice(5000)
                .build();
        VideoCamera insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<VideoCamera> video = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",video.size()>0);

        //READ ENTITY
        VideoCamera entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        VideoCamera updateEntity = new VideoCamera.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        VideoCamera newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","MK400",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(updateEntity);
        VideoCamera deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG+" DELETE",deletedEntity);

    }
}
