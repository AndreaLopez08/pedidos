package pedidosApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pedidosApi.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {  //Da acceso a los métodos: findAll, findById, save, deleteBYId
}
