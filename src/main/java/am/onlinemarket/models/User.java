package am.onlinemarket.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_tab")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String eMail;   // naev vorpes login e:

    @Column(nullable = false)
    private String firsName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "id_contacts")
    private Contacts contacts;

    @Column(nullable = false)
    private Date regDate;

    @ManyToMany()
    private Set<Role> roles;


    public User() {
    }

    public User(Long id, String eMail, String firsName, String lastName, String password, boolean status, Contacts contacts, Date regDate, Set<Role> roles) {
        this.id = id;
        this.eMail = eMail;
        this.firsName = firsName;
        this.lastName = lastName;
        this.password = password;
        this.status = status;
        this.contacts = contacts;
        this.regDate = regDate;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", eMail='" + eMail + '\'' +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", contacts=" + contacts +
                ", regDate=" + regDate +
                ", roles=" + roles +
                '}';
    }
}
