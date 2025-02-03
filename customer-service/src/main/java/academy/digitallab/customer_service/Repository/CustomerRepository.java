package academy.digitallab.customer_service.Repository;

import academy.digitallab.customer_service.Entity.Customer;
import academy.digitallab.customer_service.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByNumberID(String numberId);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByRegion(Region region);
}
