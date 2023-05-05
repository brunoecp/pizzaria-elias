import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Pizza {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double Valor;
    @ManyToMany
    @JoinTable(name = "pizza_ingredientes",
            joinColumns = @JoinColumn(name = "pizza_ingredientes"),
            inverseJoinColumns = @JoinColumn(name = "ingredientes_pizza"))
    private Set<Ingredientes> ingrediente = new HashSet<>();

    public Pizza(String frango, double v) {
    }
}
