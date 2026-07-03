package amirka.u5w1d5.services;

import amirka.u5w1d5.entities.Booking;
import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public void save(Booking booking) {
        repository.save(booking);
    }

    public List<Booking> findAll() {
        return repository.findAll();
    }

    public void book(User user, Workstation workstation, LocalDate date) {
        if (repository.existsByWorkstationAndBookingDate(workstation, date)) {
            System.out.println("Error, this workstation is already booked on: " + date);
            return;
        }
        if (repository.existsByUserAndBookingDate(user, date)) {
            System.out.println("Error this user:" + user.getUsername() + "has already booked on: " + date);
            return;
        }

        Booking booking = new Booking(user, workstation, date);
        repository.save(booking);
        System.out.println("Booking successfully created!");
    }
}
