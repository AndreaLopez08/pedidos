package pedidosApi.model;

import jakarta.persistence.*; //mapear clases como entidad en BD
import lombok.*; //Generar getters, setters y constructores

@Entity //Indica que es una entidad en BD
@Data // Genera getter y setter.
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los atributos

public class Product {
    @Id //Calve primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //Genera automáticamente el valor del Id

    private long id;
    private String nombre;
    private double precio;
 
}
