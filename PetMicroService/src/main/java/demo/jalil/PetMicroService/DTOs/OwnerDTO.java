package demo.jalil.PetMicroService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OwnerDTO {
    private Integer id;
    private String ownerName;
}
