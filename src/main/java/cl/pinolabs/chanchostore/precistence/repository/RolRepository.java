package cl.pinolabs.chanchostore.precistence.repository;

import cl.pinolabs.chanchostore.domain.dto.RolDTO;
import cl.pinolabs.chanchostore.domain.repository.RolDTORepository;
import cl.pinolabs.chanchostore.precistence.crud.RolCrud;
import cl.pinolabs.chanchostore.precistence.mapper.RolMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements RolDTORepository {

    private final RolCrud crud;
    private final RolMapper mapper;

    public RolRepository(RolCrud crud, RolMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<RolDTO>> findAll() {
        return Optional.of(mapper.toRolDTOs(crud.findAll()));
    }

    @Override
    public Optional<RolDTO> findById(int idRol) {
        return crud.findById(idRol)
                .map(mapper::toRolDTO);
    }

    @Override
    public Optional<RolDTO> findByRolName(String rolName) {
        return crud.findByRolName(rolName)
                .map(mapper::toRolDTO);
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {
        return mapper.toRolDTO(crud.save(mapper.toRolUsr(rolDTO)));
    }

    @Override
    public void delete(int idRol) {
        crud.deleteById(idRol);
    }
}
