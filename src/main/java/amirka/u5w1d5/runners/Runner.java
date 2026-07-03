package amirka.u5w1d5.runners;

import amirka.u5w1d5.entities.Building;
import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.entities.WorkstationType;
import amirka.u5w1d5.services.BookingService;
import amirka.u5w1d5.services.BuildingService;
import amirka.u5w1d5.services.UserService;
import amirka.u5w1d5.services.WorkstationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final ApplicationContext ctx;
    private final BuildingService buildingService;
    private final UserService userService;
    private final WorkstationService workstationService;
    private final BookingService bookingService;

    public Runner(ApplicationContext ctx, BuildingService buildingService, UserService userService, WorkstationService workstationService, BookingService bookingService) {
        this.ctx = ctx;
        this.buildingService = buildingService;
        this.userService = userService;
        this.workstationService = workstationService;
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        //  Buildings (we get the bean through ctx and save it in DB this way we test it if it works as well the same goes for the rest)
        if (buildingService.findAll()
                .isEmpty()) {
            buildingService.save(ctx.getBean("b", Building.class));
            buildingService.save(ctx.getBean("b1", Building.class));
            buildingService.save(ctx.getBean("b2", Building.class));
        }

        //      Users
        if (userService.findAll()
                .isEmpty()) {
            userService.save(ctx.getBean("mario", User.class));
            userService.save(ctx.getBean("marco", User.class));
            userService.save(ctx.getBean("anna", User.class));
            userService.save(ctx.getBean("rita", User.class));
        }

        //    Workstations
        if (workstationService.findAll()
                .isEmpty()) {
            workstationService.save(ctx.getBean("w", Workstation.class));
            workstationService.save(ctx.getBean("w1", Workstation.class));
            workstationService.save(ctx.getBean("w2", Workstation.class));
            workstationService.save(ctx.getBean("w3", Workstation.class));
        }
        // Let recall the data we have saved

        System.out.println("Buildings:");
        buildingService.findAll()
                .forEach(System.out::println);

        System.out.println("Users:");
        userService.findAll()
                .forEach(System.out::println);

        System.out.println("Workstations:");
        workstationService.findAll()
                .forEach(System.out::println);

        // Let's use search from WorkstationService

        System.out.println("Let's search an open space workstation in Rome");

        workstationService.search(WorkstationType.OPENSPACE, "Rome")
                .forEach(System.out::println);

        // Let's book some appointments

        bookingService.book(
                userService.findByUsername("a.greco"),
                workstationService.findByUniqueCode("W0"),
                LocalDate.now()
        );

        bookingService.book(
                userService.findByUsername("m.ricci"), workstationService.findByUniqueCode("W1"), LocalDate.now()
        );

        bookingService.book(
                userService.findByUsername("r.gallo"), workstationService.findByUniqueCode("W3"), LocalDate.now()
        );
        //Just to test if bookingService.book double checks that it's free on the same date or there is another booking on that time slot
        bookingService.book(
                userService.findByUsername("m.rossi"), workstationService.findByUniqueCode("W0"), LocalDate.now()
        );

        // Now let's get the booking

        bookingService.findAll()
                .forEach(System.out::println);
    }


}
