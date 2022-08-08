package cl.pinolabs.chanchostore.precistence.crud;

import cl.pinolabs.chanchostore.precistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
