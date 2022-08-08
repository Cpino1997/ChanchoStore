package cl.pinolabs.chanchostore.precistence.mapper;


import cl.pinolabs.chanchostore.domain.dto.ProductoDTO;
import cl.pinolabs.chanchostore.precistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ProductosMapper {

        @Mappings({
                @Mapping(source = "idProducto", target = "idProducto"),
                @Mapping(source = "nombreProducto", target = "nombreProducto"),
                @Mapping(source = "descProducto", target = "descProducto"),
                @Mapping(source = "precioProducto", target = "precioProducto"),
                @Mapping(source = "stockProducto", target = "stockProducto"),
        })
        ProductoDTO toProductoDTO(Producto producto);
        List<ProductoDTO> toProductoDTOs(List<Producto> productos);

        @InheritInverseConfiguration
        Producto toProducto(ProductoDTO productoDTO);
}



