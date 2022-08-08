package cl.pinolabs.chanchostore.precistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="venta")
public class Venta {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(name="id_cliente")
    private Integer idCliente;
    @Column(name="id_producto")
    private Integer idProducto;
    @Column(name="fechacompra")
    private Date fechacompra;
    @Column(name="totalcompra")
    private int totalcompra;

}
