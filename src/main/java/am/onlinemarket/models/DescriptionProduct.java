package am.onlinemarket.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Description_Product")
public class DescriptionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionProduct;
    private String manufacturer;
    private String unitOfMeasurement;

}
