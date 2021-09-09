package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Order order;
//6454654
    private double totalCost;

    private boolean payed;

    private String ccNumber;

    @Temporal(TIMESTAMP)
    private Date dateCreated;

}
