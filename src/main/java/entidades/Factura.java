package entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="factura")
@Audited
public class Factura implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha")
    private String fecha;

    @Column(name="numero")
    private int numero;

    @Column(name="total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cliente")
    private Cliente cliente;

    //UNIDIRECCIONAL
    // @OneToMany(cascade = CascadeType.ALL,//si elimino una factura se eliminan todos los detalles
    // orphanRemoval = true) //esto elimina todos los detalles al eliminar una factura

    //BIDIRECCIONAL
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private final List<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();

}