package lk.rash.covid.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HospitalPatient {


        private String hospitalId;
        private String hospitalName;
        private String district;
        private int patientsCount;
    }
