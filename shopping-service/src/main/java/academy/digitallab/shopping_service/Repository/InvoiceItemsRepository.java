package academy.digitallab.shopping_service.Repository;

import academy.digitallab.shopping_service.Entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
