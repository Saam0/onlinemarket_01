package am.onlinemarket.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock_tab")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Product product;
//    private String deliveryCode;
    private String photo;
    private double purchasePrice;
    private double sellingPrice;

}
