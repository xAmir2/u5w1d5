package amirka.u5w1d5.services;

import amirka.u5w1d5.entities.Building;
import amirka.u5w1d5.exceptions.BuildingNotFoundEx;
import amirka.u5w1d5.repositories.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
    }

    public void save(Building building) {
        repository.save(building);
    }

    public List<Building> findAll() {
        return repository.findAll();
    }

    public Building findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BuildingNotFoundEx(id));
    }
}
