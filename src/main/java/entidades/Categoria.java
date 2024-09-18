package entidades;
import java.io.Serializable;
import java.util.List;

import java.util.ArrayList;
import javax.persistence.*;

import lombok.*;
import org.hibernate.envers.Audited;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="categoria")
@Audited
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private  List<Articulo> articulos = new ArrayList<Articulo>();
}