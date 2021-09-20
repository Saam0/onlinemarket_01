package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

/*    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)*/

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private double quantity;

}
