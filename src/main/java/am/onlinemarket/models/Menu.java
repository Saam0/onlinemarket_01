package am.onlinemarket.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "menu_tab")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String name;
    private String type;
    private String subType;
    private String globalType;

}
