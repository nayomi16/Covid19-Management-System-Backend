package lk.rash.covid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private String id;
    private String name;
    private String hospital_id;
    private boolean is_director;

    public Doctor() {
    }

    public Doctor(String id, String name, String hospital_id, boolean is_director) {
        this.id = id;
        this.name = name;
        this.hospital_id = hospital_id;
        this.is_director = is_director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public boolean isIs_director() {
        return is_director;
    }

    public void setIs_director(boolean is_director) {
        this.is_director = is_director;
    }
}
