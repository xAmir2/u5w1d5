package amirka.u5w1d5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    public Booking() {
    }

    public Booking(User user, Workstation workstation, LocalDate bookingDate) {
        this.user = user;
        this.workstation = workstation;
        this.bookingDate = bookingDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user= " + user +
                ", workstation= " + workstation +
                ", bookingDate= " + bookingDate +
                '}';
    }
}
