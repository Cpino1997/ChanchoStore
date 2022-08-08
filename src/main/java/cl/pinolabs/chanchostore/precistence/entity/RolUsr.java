package cl.pinolabs.chanchostore.precistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolUsr {

    @Id
    @Column(name="id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name="rol_name",length = 50)
    private String rolName;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
}
