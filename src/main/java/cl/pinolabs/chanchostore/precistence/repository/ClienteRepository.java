package cl.pinolabs.chanchostore.precistence.repository;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.repository.ClienteDTORepository;
import cl.pinolabs.chanchostore.precistence.crud.ClienteCrudRepository;
import cl.pinolabs.chanchostore.precistence.entity.Cliente;
import cl.pinolabs.chanchostore.precistence.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClienteDTORepository {
    private final ClienteCrudRepository crud;
    private final ClienteMapper mapper;

    public ClienteRepository(ClienteCrudRepository crud, ClienteMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }


    @Override
    public Optional<List<ClienteDTO>> findAll() {
        return Optional.of(mapper.toClienteDTOs((List<Cliente>) crud.findAll()));
    }

    @Override
    public Optional<ClienteDTO> findById(int idCliente) {
        return crud.findById(idCliente)
                .map(mapper::toClienteDTO);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return mapper.toClienteDTO(crud.save(mapper.toCliente(clienteDTO)));
    }

    @Override
    public void delete(int idCliente) {
        crud.deleteById(idCliente);
    }
}
