package cl.pinolabs.chanchostore.precistence.mapper;


import cl.pinolabs.chanchostore.domain.dto.RolDTO;
import cl.pinolabs.chanchostore.precistence.entity.RolUsr;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
        @Mappings({
                @Mapping(source = "idRol", target = "idRol"),
                @Mapping(source = "rolName", target = "rolName"),
        })
        RolDTO toRolDTO(RolUsr rol);
        List<RolDTO> toRolDTOs(Iterable<RolUsr> roles);
        @InheritInverseConfiguration
        RolUsr toRolUsr(RolDTO rolDTO);
}
