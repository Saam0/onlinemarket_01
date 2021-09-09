package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_tab")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;



//    private DescriptionProduct description;

//    private Volume volume;


//    private boolean available;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private ProductCategory productCategory;

    @Column(nullable = false)
    private Double price;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;



}
