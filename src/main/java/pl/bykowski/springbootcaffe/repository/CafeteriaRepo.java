package pl.bykowski.springbootcaffe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.springbootcaffe.entity.Cafeteria;
import pl.bykowski.springbootcaffe.entity.Coffee;

@Repository
public interface CafeteriaRepo extends CrudRepository<Cafeteria, Long> {
}
