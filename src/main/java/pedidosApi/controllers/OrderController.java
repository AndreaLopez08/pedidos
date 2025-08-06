package pedidosApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedidosApi.dto.OrderRequest;
import pedidosApi.model.Order;
import pedidosApi.model.Product;
import pedidosApi.repository.ProductRepository;
import pedidosApi.service.OrderService;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
    

    private final OrderService orderService;
    private final ProductRepository productRepository;

    public OrderController(OrderService orderService, ProductRepository productRepository) {
        this.orderService = orderService;
        this.productRepository = productRepository;
    }
    
    @PostMapping
    public ResponseEntity<Order> crearOrden(@RequestBody OrderRequest orderRequest) {
        Order OrdenCreada = orderService.crearOrder(orderRequest);
        return ResponseEntity.ok(OrdenCreada);
    }
    @GetMapping
    public List<Product> obtenerProductos() {
        return productRepository.findAll();
    }
}
