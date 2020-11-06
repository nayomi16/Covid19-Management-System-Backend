package lk.rash.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientUpdateDto {
    private String patient_id;
    private String severity_level;
    private Date admite_date;
    private String admitted_by;

}
