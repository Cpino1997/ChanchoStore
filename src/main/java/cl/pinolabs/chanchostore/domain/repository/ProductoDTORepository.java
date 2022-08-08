package cl.pinolabs.chanchostore.domain.repository;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoDTORepository {
    Optional<List<ProductoDTO>> findAll();
    Optional<ProductoDTO> findById(int idProducto);
    ProductoDTO save(ProductoDTO productoDTO);
    void delete(int idProducto);
}
