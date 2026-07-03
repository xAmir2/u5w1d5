package amirka.u5w1d5.services;

import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.entities.WorkstationType;
import amirka.u5w1d5.exceptions.WorkstationNotFoundEx;
import amirka.u5w1d5.repositories.WorkstationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService {
    private final WorkstationRepository repository;

    public WorkstationService(WorkstationRepository repository) {
        this.repository = repository;
    }

    public void save(Workstation workstation) {
        repository.save(workstation);
    }

    public Workstation findByUniqueCode(String code) {
        return repository.findByUniqueCode(code)
                .orElseThrow(() -> new WorkstationNotFoundEx(code));
    }

    public List<Workstation> findAll() {
        return repository.findAll();
    }

    public List<Workstation> search(WorkstationType workstationType, String city) {
        return repository.findByWorkstationTypeAndBuilding_City(workstationType, city);
    }
}
