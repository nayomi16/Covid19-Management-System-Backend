package lk.rash.covid.dto;

import lombok.*;
import org.springframework.stereotype.Component;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class PatientCount {
    private int activecount;
    private int discharged;
}
