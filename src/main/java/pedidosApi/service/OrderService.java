package pedidosApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pedidosApi.dto.OrderRequest;
import pedidosApi.dto.OrderRequestItems;
import pedidosApi.model.Order;
import pedidosApi.model.OrderItem;
import pedidosApi.model.Product;
import pedidosApi.repository.OrderRepository;
import pedidosApi.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    // Componentes que permitem guardar pedidos, y consultar productos desde la base de datos.
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    /* Recibe una lista de productos con cantidad, calcula total, aplica descuento y guarda el pedido */
    public Order crearOrder(OrderRequest orderRequest){
        // Inicialización
        List<OrderRequestItems> items = orderRequest.getItems();
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        // Recorrido de productos
        for (OrderRequestItems item : items) {
            Optional<Product> optionalProduct = productRepository.findById(item.getProductoId());
            if (optionalProduct.isEmpty()) {
                throw new RuntimeException("Producto con ID " + item.getProductoId() + " no encontrado");
            }

            // Calculo total por ítem
            Product product = optionalProduct.get();
            double itemTotal = product.getPrecio() * item.getCantidad();

            // Se crea el ítem del pedido con producto, cantidad y total
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setCantidad(item.getCantidad());
            orderItem.setTotal(itemTotal);

            orderItems.add(orderItem);
            total += itemTotal;
        }

        // Calculo del descuento
        double descuento = total > 500 ? total * 0.10 : 0;
        double cantidadFinal = total - descuento;

        // Crear el pedido
        Order order = new Order();
        order.setItems(orderItems);
        order.setCantidadTotal(total);
        order.setDescuento(descuento);
        order.setCantidadFinal(cantidadFinal);

        // Guardar el pedido completo en la base de datos
        return orderRepository.save(order);
    } 
}
