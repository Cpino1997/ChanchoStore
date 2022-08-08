package cl.pinolabs.chanchostore.precistence.mapper;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.precistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper {

        @Mappings({
                @Mapping(source = "idCliente", target = "idCliente"),
                @Mapping(source = "nombre", target = "nombre"),
                @Mapping(source = "rut", target = "rut"),
                @Mapping(source = "email", target = "email"),
                @Mapping(source = "telefono", target = "telefono"),
                @Mapping(source = "direccion", target = "direccion"),
        })
        ClienteDTO toClienteDTO(Cliente cliente);
        List<ClienteDTO> toClienteDTOs(List<Cliente> clientes);

        @InheritInverseConfiguration
        Cliente toCliente(ClienteDTO clienteDTO);
}

