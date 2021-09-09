package am.onlinemarket.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productcategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

}
