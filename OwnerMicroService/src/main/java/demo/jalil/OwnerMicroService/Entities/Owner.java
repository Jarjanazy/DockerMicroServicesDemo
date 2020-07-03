package demo.jalil.OwnerMicroService.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(nullable = false)
    String ownerName;

    public Owner(String ownerName) {
        this.ownerName = ownerName;
    }
}

