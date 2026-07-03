package amirka.u5w1d5.entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstations = new ArrayList<>();

    public Building() {
    }

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<Workstation> getWorkstations() {
        return workstations;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", address= '" + address + '\'' +
                ", city= '" + city + '\'' +
                '}';
    }
}
