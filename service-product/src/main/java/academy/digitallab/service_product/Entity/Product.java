package academy.digitallab.service_product.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="El nombre del campo no debe estar vacio")
    private String name;
    private String description;

    @Positive(message = "El stock debe ser mayor que cero")
    private Double stock;


    private Double price;
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @NotNull(message = "La categoria no debe estar vacia")
    @ManyToOne(fetch = FetchType.LAZY) //Carga de manera perezosa solo cuando se necesite en cambio eager carga todas
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Category category;

}
