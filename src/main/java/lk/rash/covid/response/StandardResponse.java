package lk.rash.covid.response;

import lk.rash.covid.dto.PatientCount;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StandardResponse {
    private int code;
    private String message;
    private Object data;


}
