package edu.simplyct.leagueo.repository;

import edu.simplyct.leagueo.model.Wod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by cyril on 6/11/15.
 */
@Service
public interface WodRepository extends CrudRepository<Wod, Long> {
}
