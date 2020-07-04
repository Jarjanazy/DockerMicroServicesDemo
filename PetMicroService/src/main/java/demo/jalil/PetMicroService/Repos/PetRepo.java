package demo.jalil.PetMicroService.Repos;

import demo.jalil.PetMicroService.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends JpaRepository<Pet, Integer>{
}
