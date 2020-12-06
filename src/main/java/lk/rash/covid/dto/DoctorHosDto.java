package lk.rash.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorHosDto {
    private int id;
    private String name;
    private String hospitalId;
    private boolean isDirector;
    private String email;

}
