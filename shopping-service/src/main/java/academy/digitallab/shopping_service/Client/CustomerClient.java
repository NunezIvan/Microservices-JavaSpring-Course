package academy.digitallab.shopping_service.Client;

import academy.digitallab.shopping_service.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping(value = "/customers/{id}")
    @CircuitBreaker(name = "getCustomer", fallbackMethod = "getCustomerFallback")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

    // Fallback en el propio Feign Client
    default ResponseEntity<Customer> getCustomerFallback(long id, Throwable throwable) {
        // Aquí puedes manejar la respuesta cuando falla
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("none")
                .build();
        return ResponseEntity.ok(customer);
    }
}
