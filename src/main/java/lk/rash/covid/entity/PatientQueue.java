package lk.rash.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientQueue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
   private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;




}
