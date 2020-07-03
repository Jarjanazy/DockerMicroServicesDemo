package demo.jalil.OwnerMicroService.CommandLineRunners;

import demo.jalil.OwnerMicroService.Entities.Owner;
import demo.jalil.OwnerMicroService.Repos.OwnerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AddOwnersRunner implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(AddOwnersRunner.class);

    private OwnerRepo ownerRepo;

    AddOwnersRunner(OwnerRepo ownerRepo){
        this.ownerRepo = ownerRepo;
    }

    @Override
    public void run(String... args){
        Owner owner1 = new Owner("Ahmed");
        Owner owner2 = new Owner("Abdo");

        log.info("Adding new Owners");
        ownerRepo.saveAll(Arrays.asList(owner1, owner2));
    }
}
