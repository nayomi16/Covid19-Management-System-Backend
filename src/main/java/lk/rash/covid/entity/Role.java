package lk.rash.covid.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="roles")
public class Role {
    @Id
    @Column(name = "role_id",length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    @Column(name = "role_name",length = 10)
    private String roleName;
}
