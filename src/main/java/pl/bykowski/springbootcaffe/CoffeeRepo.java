package pl.bykowski.springbootcaffe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepo extends CrudRepository<Coffee, Long> {
}
