package cl.pinolabs.chanchostore.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VentaDTO {
    private Integer idVenta;
    private Integer idCliente;
    private Integer idProducto;
    private ProductoDTO productoDTO;
    private ClienteDTO clienteDTO;
    private Date fechacompra;
    private int totalcompra;{
}
}
