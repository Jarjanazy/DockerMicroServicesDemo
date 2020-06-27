package demo.jalil.OwnerMicroService.Controllers;

import demo.jalil.OwnerMicroService.Entities.Owner;
import demo.jalil.OwnerMicroService.Repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class OwnerController {
    private OwnerRepo ownerRepo;

    @Autowired
    public OwnerController(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @PostMapping("/owner")
    public ResponseEntity<?> addOwner(@RequestBody Owner owner){
        ownerRepo.save(owner);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<?> getOwner(@PathVariable Integer id){
        Optional<Owner> owner = ownerRepo.findById(id);

        if(owner.isPresent()) return ResponseEntity.ok().body(owner);
        else return ResponseEntity.badRequest().body("No such owner is found");
    }


}
