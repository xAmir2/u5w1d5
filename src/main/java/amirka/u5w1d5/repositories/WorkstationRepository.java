package amirka.u5w1d5.repositories;

import amirka.u5w1d5.entities.Workstation;
import amirka.u5w1d5.entities.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
    Optional<Workstation> findByUniqueCode(String uniqueCode);

    List<Workstation> findByWorkstationTypeAndBuilding_City(
            WorkstationType workstationType,
            String city
    );


}
