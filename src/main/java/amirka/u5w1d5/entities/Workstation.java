package amirka.u5w1d5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_code", unique = true)
    private String uniqueCode;

    private String description;

    @Column(name = "workstation_type")
    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;

    private int maxPeople;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation() {
    }

    public Workstation(String uniqueCode, String description, WorkstationType workstationType, int maxPeople, Building building) {
        this.uniqueCode = uniqueCode;
        this.description = description;
        this.workstationType = workstationType;
        this.maxPeople = maxPeople;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getDescription() {
        return description;
    }

    public WorkstationType getWorkstationType() {
        return workstationType;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "Workstation{" +
                "uniqueCode= '" + uniqueCode + '\'' +
                ", description= '" + description + '\'' +
                ", workstationType= " + workstationType +
                ", maxPeople= " + maxPeople +
                ", building= " + building.getName() +
                '}';
    }
}
