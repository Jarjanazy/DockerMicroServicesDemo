package demo.jalil.OwnerMicroService.Repos;

import demo.jalil.OwnerMicroService.Entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByOwnerName(String ownerName);
}
