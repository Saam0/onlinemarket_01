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







}