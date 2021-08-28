package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "order_tab")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderProduct> orderProducts;

//    @OneToOne
//    private Bill bill;

    private int quantity;

    private double productsCost;

//    private Date dateCreated;

    private int deliveryCost;

    private boolean deliveryIncluded;

    private boolean executed;





}
