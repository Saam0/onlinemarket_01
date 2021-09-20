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

/*
    @ManyToOne
    @JoinColumn(name = "id_category")
    private ProductCategory productCategory;*/

    @ManyToOne(fetch = FetchType.LAZY)
    private Catalog catalog;





    @Column(nullable = false)
    private Double price;

    private String image;


    //    @ManyToOne
//    @JoinColumn(name = "id_supplier")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "supplier_id", referencedColumnName = "id")

/*

    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    @MapsId("id")
*/

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

}
