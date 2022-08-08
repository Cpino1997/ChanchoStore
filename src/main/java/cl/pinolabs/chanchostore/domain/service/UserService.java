package cl.pinolabs.chanchostore.domain.service;

import cl.pinolabs.chanchostore.domain.dto.RolDTO;
import cl.pinolabs.chanchostore.domain.dto.UserDTO;
import cl.pinolabs.chanchostore.domain.repository.UserDTORepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDTORepository repo;

    public UserService(UserDTORepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = repo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(userDTO.getUsername(),
                userDTO.getPassword(),
                mapperRols(userDTO.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapperRols(List<RolDTO> roles){
        return roles.stream()
                .map(rolDTO -> new SimpleGrantedAuthority(rolDTO.getRolName()))
                .collect(Collectors.toList());
    }
}

