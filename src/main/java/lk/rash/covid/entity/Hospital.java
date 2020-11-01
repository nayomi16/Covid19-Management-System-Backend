package lk.rash.covid.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private String id;
    private String name;
    private String district;
    private int location_x;
    private int location_y;
}
