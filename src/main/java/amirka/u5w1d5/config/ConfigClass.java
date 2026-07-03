package amirka.u5w1d5.config;

import amirka.u5w1d5.entities.Building;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
    @Bean
    public Building b() {
        return new Building("Building", "Via Milano 20", "Rome");
    }


}
