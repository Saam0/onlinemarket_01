package am.onlinemarket.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @OneToOne
    @MapsId
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;


}
