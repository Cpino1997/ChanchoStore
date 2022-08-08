package cl.pinolabs.chanchostore.precistence.crud;
import cl.pinolabs.chanchostore.precistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrud extends CrudRepository<Usuario, String> {
    boolean existsByUsername(String username);
}
