package lk.rash.covid.response;

import lk.rash.covid.dto.HospitalBedRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitaBedResponse {
    private String hospitalId;
    private String hospitalName;
    private List<HospitalBedRespDto> hospitalBeds;
}

