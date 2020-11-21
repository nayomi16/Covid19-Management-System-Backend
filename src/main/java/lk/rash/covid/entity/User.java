package lk.rash.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
//    @OneToOne
//    @JoinColumn(name = "user_name")
@Column(name = "user_name")
    private String Username;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "role_id")})
    private List<Role> rolea;

}
