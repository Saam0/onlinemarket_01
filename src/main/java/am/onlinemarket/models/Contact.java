package am.onlinemarket.models;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    private String street;

    @Column(nullable = false)
    private String homeOrOffice;


    public Contact() {
    }

    public Contact(Long id, Set<User> user, Set<Supplier> supplier, String phone, String country, String city, String street, String homeOrOffice) {
        this.id = id;
        this.user = user;
        this.supplier = supplier;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeOrOffice = homeOrOffice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.supplier = supplier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeOrOffice() {
        return homeOrOffice;
    }

    public void setHomeOrOffice(String homeOrOffice) {
        this.homeOrOffice = homeOrOffice;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", user=" + user +
                ", supplier=" + supplier +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", homeOrOffice='" + homeOrOffice + '\'' +
                '}';
    }
}
