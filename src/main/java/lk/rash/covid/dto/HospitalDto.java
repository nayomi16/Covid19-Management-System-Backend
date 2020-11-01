package lk.rash.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private String id;
    private String name;
    private String district;
    private int location_x;
    private int location_y;
}
