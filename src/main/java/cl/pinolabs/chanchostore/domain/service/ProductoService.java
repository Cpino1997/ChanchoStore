package cl.pinolabs.chanchostore.domain.service;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.dto.ProductoDTO;
import cl.pinolabs.chanchostore.domain.repository.ClienteDTORepository;
import cl.pinolabs.chanchostore.domain.repository.ProductoDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoDTORepository repo;

    public ProductoService(ProductoDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<ProductoDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<ProductoDTO> findById(int idProducto){
        return repo.findById(idProducto);
    }

    public ProductoDTO save(ProductoDTO productoDTO){
        return repo.save(productoDTO);
    }

    public boolean delete(int idProducto){
        return findById(idProducto)
                .map(productoDTO -> {
                    repo.delete(idProducto);
                    return true;})
                .orElse(false);
    }
}
