package edu.simplyct.boxbasics.repository;

import edu.simplyct.boxbasics.model.Wod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cyril on 6/11/15.
 */
@Repository
public interface WodRepository extends CrudRepository<Wod, Long> {
}
