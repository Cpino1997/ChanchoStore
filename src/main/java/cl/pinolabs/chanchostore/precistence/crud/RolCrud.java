package cl.pinolabs.chanchostore.precistence.crud;


import cl.pinolabs.chanchostore.precistence.entity.RolUsr;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolCrud extends CrudRepository<RolUsr, Integer> {

    Optional<RolUsr> findByRolName(String rolName);
}