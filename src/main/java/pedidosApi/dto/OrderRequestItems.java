package pedidosApi.dto;

import lombok.Data;

@Data // Genera getter y setter.
public class OrderRequestItems {
    private Long productoId;
    private int cantidad;
}
