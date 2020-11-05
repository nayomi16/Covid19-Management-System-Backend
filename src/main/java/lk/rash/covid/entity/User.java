package lk.rash.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String Username;
    private String password;

}
