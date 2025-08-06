package pedidosApi.DataBase;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pedidosApi.model.Product;
import pedidosApi.repository.ProductRepository;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final ProductRepository productRepository;

    @PostConstruct
    public void init () {
        if (productRepository.count() == 0) {
            productRepository.save(new Product(0L, "Teclado", 120));
            productRepository.save(new Product(0L, "Mouse", 80.));
            productRepository.save(new Product(0L, "Pantalla", 320.0));
        }
    }
}
