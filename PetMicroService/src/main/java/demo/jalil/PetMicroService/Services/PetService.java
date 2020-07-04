package demo.jalil.PetMicroService.Services;

import demo.jalil.PetMicroService.DTOs.OwnerDTO;
import demo.jalil.PetMicroService.Entities.Pet;
import demo.jalil.PetMicroService.Repos.PetRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PetService {
    private final Logger log = LoggerFactory.getLogger(PetService.class);

    private PetRepo petRepo;

    private WebClient.Builder webClient;

    public PetService(PetRepo petRepo, WebClient.Builder webClient) {
        this.petRepo = petRepo;
        this.webClient = webClient;
    }

    public void checkAndAdoptPet(Pet pet){
        if(pet.getOwnerName() == null){
            log.error("No owner was specified");
        }

        String requestString = String.format("http://ownerService:8085/ownerByName/%s", pet.getOwnerName());
        log.info(requestString);


        fetchOwnerFromOwnerService(requestString);

        petRepo.save(pet);
    }

    private void fetchOwnerFromOwnerService(String requestString) {
        try{
            OwnerDTO ownerDTO = webClient
                    .build()
                    .get()
                    .uri(requestString)
                    .retrieve()
                    .bodyToMono(OwnerDTO.class)
                    .block();
            if (ownerDTO != null) log.info(String.format("the owner %s is found", ownerDTO.getOwnerName()));
        }catch (Exception e){
            log.error("No owner is fetched");
        }
    }

}
