package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_tab")
public class Image {
    @Id
    private Long Id;

    private String name;



}
