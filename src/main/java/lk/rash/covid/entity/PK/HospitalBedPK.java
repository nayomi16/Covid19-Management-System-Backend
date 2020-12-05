package lk.rash.covid.entity.PK;

import lk.rash.covid.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HospitalBedPK implements Serializable {
    @Column(name = "id")
    private int id;
    @Column(name = "hospital_id")
    private String hospitalId;

}
