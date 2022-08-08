package cl.pinolabs.chanchostore.precistence.mapper;

import cl.pinolabs.chanchostore.domain.dto.UserDTO;
import cl.pinolabs.chanchostore.precistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "roles", target = "roles"),
    })
    UserDTO toUserDTO(Usuario usuario);
    List<UserDTO> toUserDTOs(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(UserDTO usuarioDTO);
}

