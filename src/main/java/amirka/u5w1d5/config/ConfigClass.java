package amirka.u5w1d5.config;

import amirka.u5w1d5.entities.Building;
import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.entities.WorkstationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
    @Bean
    public Building b() {
        return new Building("Building", "Via Milano, 20", "Rome");
    }

    @Bean
    public Building b1() {
        return new Building("Building 1", "Via XX Settembre, 11", "Milan");
    }

    @Bean
    public Building b2() {
        return new Building("Building 2", "Via Pio XI, 34", "Turin");
    }

    @Bean
    public User mario() {
        return new User("m.rossi", "Mario Rossi", "mariorossi@gmail.com");
    }

    @Bean
    public User marco() {
        return new User("m.ricci", "Marco Ricci", "marcoricci@gmail.com");
    }

    @Bean
    public User anna() {
        return new User("a.greco", "Anna Greco", "annagreco@gmail.com");
    }

    @Bean
    public User rita() {
        return new User("r.gallo", "Rita Gallo", "ritagallo@gmail.com");
    }

    @Bean
    public Workstation w() {
        return new Workstation("W0", "Open Desk Area", WorkstationType.OPENSPACE, 1, b());
    }

    @Bean
    public Workstation w1() {
        return new Workstation("W1", "Private Office", WorkstationType.PRIVATE, 1, b());
    }

    @Bean
    public Workstation w2() {
        return new Workstation("W2", "Meeting Room 1", WorkstationType.MEETING_ROOM, 10, b1());
    }

    @Bean
    public Workstation w3() {
        return new Workstation("W3", "Open Space First Floor", WorkstationType.OPENSPACE, 1, b1());
    }


}
