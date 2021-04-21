package am.onlinemarket.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_t")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eMail;   // naev vorpes login e:
    private String firsName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Date regDate;
    private Date modifyDate;
    private String role;


}
