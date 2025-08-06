package pedidosApi.model;

import jakarta.persistence.*; //mapear clases como entidad en BD
import lombok.*; //Generar getters, setters y constructores

@Entity //Indica que es una entidad en BD
@Data // Genera getter y setter.
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los atributos

public class OrderItem {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long Id;

    @ManyToOne //Relación entre entidades
    private Product product;
    private int cantidad;
    private double total;
    
}
