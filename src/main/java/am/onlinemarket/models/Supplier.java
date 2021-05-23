package am.onlinemarket.models;

import javax.persistence.*;

@Entity
@Table(name = "supplier_tab")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String title;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "id_contacts")
    private Contacts contacts;


    public Supplier() {
    }

    public Supplier(Long id, String title, Contacts contacts) {
        this.id = id;
        this.title = title;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}