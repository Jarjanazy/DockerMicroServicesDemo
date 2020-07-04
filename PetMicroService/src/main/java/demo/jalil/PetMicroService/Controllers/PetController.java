package demo.jalil.PetMicroService.Controllers;

import demo.jalil.PetMicroService.Entities.Pet;
import demo.jalil.PetMicroService.Services.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    private final Logger log = LoggerFactory.getLogger(PetController.class);
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/adopt")
    ResponseEntity<?> adoptPet(@RequestBody Pet pet){
        try{

            petService.checkAndAdoptPet(pet);

            return ResponseEntity.ok().build();

        }catch (Exception e){

            log.error("An error happened while adpoting the pet", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}
