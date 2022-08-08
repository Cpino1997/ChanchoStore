package cl.pinolabs.chanchostore.precistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

        @Id
        @Column(length = 50)
        private String username;
        @Column(length = 100)
        private String password;

        private Boolean enabled;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "roles_usuario",
                joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
                inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id_rol"))
        private List<RolUsr> roles;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public List<RolUsr> getRoles() {
            return roles;
        }

        public void setRoles(List<RolUsr> roles) {
            this.roles = roles;
        }
    }

