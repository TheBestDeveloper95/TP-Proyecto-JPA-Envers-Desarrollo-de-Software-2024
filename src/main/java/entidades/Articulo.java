package entidades;
import java.io.Serializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.envers.Audited;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "articulo")
@Audited
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name="denominacion")
    private String denominacion;

    @Column(name="precio")
    private int precio;

    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    private  List<DetalleFactura> articulosDetalleFactura = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="articulo_categoria",
            joinColumns = @JoinColumn(name = "articuloID"),
            inverseJoinColumns = @JoinColumn(name = "categoriaID")
    )

    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();
}