package lk.rash.covid.entity;

import lk.rash.covid.entity.PK.HospitalBedPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="`hospital_bed`")
public class HospitalBed implements Serializable {
    @EmbeddedId
    private  HospitalBedPK hospitalBedPK;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;


//    public HospitalBed(int id, String hospital_id, String patient_id) {
//        this.hospitalBedPK.setId(id);
//        this.hospitalBedPK.setHospitalId(hospital_id);
//        this.patient.setId(patient_id);
//    }
}
