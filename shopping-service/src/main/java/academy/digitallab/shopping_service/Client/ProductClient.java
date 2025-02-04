package academy.digitallab.shopping_service.Client;


import academy.digitallab.shopping_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="product-service")
@RequestMapping(value = "/products")
public interface ProductClient {
    @GetMapping(value="/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId);

    @PatchMapping(value="/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(name="quantity") Double quantity);
}
