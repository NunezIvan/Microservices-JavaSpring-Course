package academy.digitallab.service_product.Repository;

import academy.digitallab.service_product.Entity.Category;
import academy.digitallab.service_product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}

