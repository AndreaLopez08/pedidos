package pedidosApi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Habilita CORS para que la backend se pueda conectar con React
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica todas las rutas
        .allowedOrigins("http://localhost:3000") // Permite peticiones desde el frontend React
        .allowedMethods("*"); // Permite todos los métodos (GET, POST, ect..)
    }
    
}
