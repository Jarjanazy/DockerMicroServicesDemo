package demo.jalil.OwnerMicroService.Repos;

import demo.jalil.OwnerMicroService.Entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
}
