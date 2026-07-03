package amirka.u5w1d5.runners;

import amirka.u5w1d5.entities.Building;
import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.services.BookingService;
import amirka.u5w1d5.services.BuildingService;
import amirka.u5w1d5.services.UserService;
import amirka.u5w1d5.services.WorkstationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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
        // Buildings (we get the bean through ctx and save it in DB this way we test it if it works as well the same goes for the rest)
        buildingService.save(ctx.getBean("b", Building.class));
        buildingService.save(ctx.getBean("b1", Building.class));
        buildingService.save(ctx.getBean("b2", Building.class));

        // Users
        userService.save(ctx.getBean("mario", User.class));
        userService.save(ctx.getBean("marco", User.class));
        userService.save(ctx.getBean("anna", User.class));
        userService.save(ctx.getBean("rita", User.class));

        // Workstations
        workstationService.save(ctx.getBean("w", Workstation.class));
        workstationService.save(ctx.getBean("w1", Workstation.class));
        workstationService.save(ctx.getBean("w2", Workstation.class));
        workstationService.save(ctx.getBean("w3", Workstation.class));

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


    }
}
