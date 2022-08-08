package cl.pinolabs.chanchostore.domain.repository;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteDTORepository {
    Optional<List<ClienteDTO>> findAll();
    Optional<ClienteDTO> findById(int idCliente);
    ClienteDTO save(ClienteDTO clienteDTO);
    void delete(int idCliente);
}
