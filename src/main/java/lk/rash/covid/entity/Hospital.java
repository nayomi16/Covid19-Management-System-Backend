package lk.rash.covid.entity;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Table(name="`hospital`")
public class Hospital {
    @Id
    private String id;
    private String name;
    private String district;
    private int location_x;
    private int location_y;


}
