package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier_tab")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String supplierName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "supplier_contacts", joinColumns = {@JoinColumn(name = "supplier_id")},
            inverseJoinColumns = {@JoinColumn(name = "contacts_id")})
    private Set<Contact> contacts;




}