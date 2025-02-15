package academy.digitallab.shopping_service.model;

import lombok.*;

import java.util.Date;

@Data
public class Product {
    private Long id;

    private String name;
    private String description;

    private Double stock;


    private Double price;
    private String status;

    private Date createAt;

    private Category category;

}
