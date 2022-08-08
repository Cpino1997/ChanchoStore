package cl.pinolabs.chanchostore.domain.dto;

import lombok.Data;

@Data
public class RolDTO {
        private Integer idRol;
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

