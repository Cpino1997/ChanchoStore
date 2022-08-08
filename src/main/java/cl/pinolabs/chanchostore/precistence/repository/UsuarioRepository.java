package cl.pinolabs.chanchostore.precistence.repository;

import cl.pinolabs.chanchostore.domain.dto.UserDTO;
import cl.pinolabs.chanchostore.domain.repository.UserDTORepository;
import cl.pinolabs.chanchostore.precistence.crud.UsuarioCrud;
import cl.pinolabs.chanchostore.precistence.entity.Usuario;
import cl.pinolabs.chanchostore.precistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserDTORepository {

    private final UsuarioCrud crud;
    private final UserMapper mapper;

    public UsuarioRepository(UsuarioCrud crud, UserMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<UserDTO>> findAll() {
        return Optional.of(mapper.toUserDTOs((List<Usuario>) crud.findAll()));
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return crud.findById(username)
                .map(mapper::toUserDTO);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return mapper.toUserDTO(crud.save(mapper.toUsuario(userDTO)));
    }

    @Override
    public void delete(String username) {
        crud.deleteById(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return crud.existsByUsername(username);
    }
}