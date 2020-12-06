package lk.rash.covid.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HospitalBedRespDto {
    private int bedId;
    private String patientId;
    private boolean isAdmitted;
    private boolean isDischarged;

}