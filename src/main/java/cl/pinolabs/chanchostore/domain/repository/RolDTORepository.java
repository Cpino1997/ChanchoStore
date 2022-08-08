package cl.pinolabs.chanchostore.domain.repository;

import cl.pinolabs.chanchostore.domain.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolDTORepository {
    Optional<List<RolDTO>> findAll();
    Optional<RolDTO> findById(int idRol);
    Optional<RolDTO> findByRolName(String rolName);
    RolDTO save(RolDTO rolDTO);
    void delete(int idRol);
}