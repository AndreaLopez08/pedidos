package pedidosApi.model;

import java.util.List;

import jakarta.persistence.*; //mapear clases como entidad en BD
import lombok.*; //Generar getters, setters y constructores

@Entity //Indica que es una entidad en BD
@Table(name =  "orders") // "oder" es la palabra reservada en SQL
@Data // Genera getter y setter.
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los atributos

public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long Id;

    @OneToMany(cascade = CascadeType.ALL)  //Una orden tiene muchos ítems
    private List<OrderItem> items;
    private double cantidadTotal;
    private double descuento;
    private double cantidadFinal;
        
}