package za.ac.cput.assignment6.Repos;

import java.util.Set;

/**
 * Created by louisane Malu on 4/20/2016.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
