package academy.digitallab.shopping_service.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_invoice_items")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Positive(message="El stock debe ser mayor a 0")
    private Double quantity;
    private Double price;

    @Column(name="product_id")
    private Long productId;

    @Transient
    private double subTotal;

    public Double getSubTotal(){
        if(this.price>0 && this.quantity>0){
            return this.price * this.quantity;
        }else{
            return (double)0;
        }
    }

    public InvoiceItem(){
        this.quantity = (double) 0 ;
        this.price = (double) 0 ;
    }
}
