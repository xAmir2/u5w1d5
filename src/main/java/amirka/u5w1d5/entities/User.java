package amirka.u5w1d5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String fullname;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    public User() {
    }

    public User(String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
