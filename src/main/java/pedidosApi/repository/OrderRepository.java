package pedidosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidosApi.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {  
} 