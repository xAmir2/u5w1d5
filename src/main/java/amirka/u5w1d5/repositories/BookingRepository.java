package amirka.u5w1d5.repositories;

import amirka.u5w1d5.entities.Booking;
import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByWorkstationAndBookingDate(
            Workstation workstation, LocalDate bookingDate
    );

    boolean existsByUserAndBookingDate(
            User user, LocalDate bookingDate
    );
}
