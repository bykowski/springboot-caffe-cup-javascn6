package pl.bykowski.springbootcaffe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.springbootcaffe.entity.Coffee;

@Repository
public interface CoffeeRepo extends CrudRepository<Coffee, Long> {
}
