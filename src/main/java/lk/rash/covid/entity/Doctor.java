package lk.rash.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Table(name = "`doctor`")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)

//    private String id;
    private User user;
    private String name;
    private String email;
    @Column(name = "is_director", columnDefinition = "boolean default true")
    private boolean isDirector;
//    @Column(name="hospital_id")


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private Hospital hospital;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="hospital_id")
//    private Hospital hospital;


//    public Doctor() {
//    }
//
//    public Doctor(String id, String name, String hospital_id, boolean is_director) {
//        this.id = id;
//        this.name = name;
//        this.hospital_id = hospital_id;
//        this.is_director = is_director;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getHospital_id() {
//        return hospital_id;
//    }
//
//    public void setHospital_id(String hospital_id) {
//        this.hospital_id = hospital_id;
//    }
//
//    public boolean isIs_director() {
//        return is_director;
//    }
//
//    public void setIs_director(boolean is_director) {
//        this.is_director = is_director;
//    }
}
