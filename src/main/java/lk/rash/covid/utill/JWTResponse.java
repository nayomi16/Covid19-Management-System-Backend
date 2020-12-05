package lk.rash.covid.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {
    private String username;
    private String token;
    private List<String> roles;

}
