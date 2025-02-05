package academy.digitallab.shopping_service.Client;


import academy.digitallab.shopping_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="product-service")

public interface ProductClient {
    @GetMapping(value="/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId);

    @PutMapping(value="/products/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(name="quantity") Double quantity);
}
