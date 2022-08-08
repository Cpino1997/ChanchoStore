package cl.pinolabs.chanchostore.precistence.repository;

import cl.pinolabs.chanchostore.domain.dto.ProductoDTO;
import cl.pinolabs.chanchostore.domain.repository.ProductoDTORepository;
import cl.pinolabs.chanchostore.precistence.crud.ProductoCrudRepository;
import cl.pinolabs.chanchostore.precistence.entity.Cliente;
import cl.pinolabs.chanchostore.precistence.entity.Producto;
import cl.pinolabs.chanchostore.precistence.mapper.ProductosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductoDTORepository{

    private final ProductoCrudRepository crud;
    private final ProductosMapper mapper;

    public ProductoRepository(ProductoCrudRepository crud, ProductosMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<ProductoDTO>> findAll() {
        return Optional.of(mapper.toProductoDTOs((List<Producto>) crud.findAll()));
    }

    @Override
    public Optional<ProductoDTO> findById(int idProducto) {

        return crud.findById(idProducto)
                .map(mapper::toProductoDTO);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        return mapper.toProductoDTO(crud.save(mapper.toProducto(productoDTO)));
    }

    @Override
    public void delete(int idProducto) {
        crud.deleteById(idProducto);
    }
}
