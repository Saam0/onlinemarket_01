package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@Table(name = "contacts_tab")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "contacts")
    private Set<User> user;

    @ManyToMany(mappedBy = "contacts")
    private Set<Supplier> supplier;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;


}
