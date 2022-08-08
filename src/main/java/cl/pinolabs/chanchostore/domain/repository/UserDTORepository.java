package cl.pinolabs.chanchostore.domain.repository;

import cl.pinolabs.chanchostore.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDTORepository {
    Optional<List<UserDTO>> findAll();
    Optional<UserDTO> findByUsername(String username);
    UserDTO save(UserDTO userDTO);
    void delete(String username);
    boolean existsByUsername(String username);
}
