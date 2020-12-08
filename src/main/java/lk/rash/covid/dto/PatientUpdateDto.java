package lk.rash.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientUpdateDto {
    private String patientId;
    private String doctorId;
    private String severityLevel;
    private Date date;
    private String role;

}
