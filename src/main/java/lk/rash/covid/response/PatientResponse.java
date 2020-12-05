package lk.rash.covid.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    private String serialNo;
    private int bedNo;
    private String hospitalName;
    private int queueNo;
}
