package pl.bykowski.springbootcaffe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.springbootcaffe.entity.Cup;

@Repository
public interface CupRepo extends CrudRepository<Cup, Long> {
}
