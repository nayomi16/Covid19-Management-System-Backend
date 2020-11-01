package lk.rash.covid.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalBedDto {

    private String id;
    private String hospital_id;
    private String patient_id;

}
