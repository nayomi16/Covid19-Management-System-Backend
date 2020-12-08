package lk.rash.covid.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HospitalCount {
    private String hosId;
    private String name;
    private String district;
    private int availableBedCount;
    private int locationX;
    private int locationY;
}