package cl.pinolabs.chanchostore.domain.service;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.repository.ClienteDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteDTORepository repo;

    public ClienteService(ClienteDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<ClienteDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<ClienteDTO> findById(int idCliente){
        return repo.findById(idCliente);
    }
    public ClienteDTO save(ClienteDTO clienteDTO){
        return repo.save(clienteDTO);
    }

    public boolean delete(int idCliente){
        return findById(idCliente)
                .map(clienteDTO -> {
                    repo.delete(idCliente);
                    return true;})
                .orElse(false);
    }
}
