package academy.digitallab.service_product.service;

import academy.digitallab.service_product.Entity.Category;
import academy.digitallab.service_product.Entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> ListAllProducts();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);
}
