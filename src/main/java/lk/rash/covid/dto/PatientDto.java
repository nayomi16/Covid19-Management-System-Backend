package lk.rash.covid.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

   private String id;
    private String first_name;
    private String last_name;
    private String district;
    private int location_x;
    private int location_y;
    private String severity_level;
    private String gender;
    private String contact;
    private String email;

//    public PatientDto(String id, String first_name, String last_name, String district, int location_x, int location_y, String severity_level, String gender, String contact, String email, int age, Date admit_date, String admitted_by, Date discharge_date, String discharged_by) {
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.district = district;
//        this.location_x = location_x;
//        this.location_y = location_y;
//        this.severity_level = severity_level;
//        this.gender = gender;
//        this.contact = contact;
//        this.email = email;
//        this.age = age;
//        this.admit_date = admit_date;
//        this.admitted_by = admitted_by;
//        this.discharge_date = discharge_date;
//        this.discharged_by = discharged_by;
//    }
//
    private int age;
    private Date admit_date;
    private String admitted_by;
    private Date discharge_date;
    private String discharged_by;

//    public PatientDto() {
//    }
//
//    public PatientDto(String id, String first_name, String last_name, String district, int location_x, int location_y, String severity_level, String gender, String contact, String email, int age, java.util.Date admit_date, String admitted_by, java.util.Date discharge_date, String discharged_by) {
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
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
//
//    public int getLocation_x() {
//        return location_x;
//    }
//
//    public void setLocation_x(int location_x) {
//        this.location_x = location_x;
//    }
//
//    public int getLocation_y() {
//        return location_y;
//    }
//
//    public void setLocation_y(int location_y) {
//        this.location_y = location_y;
//    }
//
//    public String getSeverity_level() {
//        return severity_level;
//    }
//
//    public void setSeverity_level(String severity_level) {
//        this.severity_level = severity_level;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Date getAdmit_date() {
//        return admit_date;
//    }
//
//    public void setAdmit_date(Date admit_date) {
//        this.admit_date = admit_date;
//    }
//
//    public String getAdmitted_by() {
//        return admitted_by;
//    }
//
//    public void setAdmitted_by(String admitted_by) {
//        this.admitted_by = admitted_by;
//    }
//
//    public Date getDischarge_date() {
//        return discharge_date;
//    }
//
//    public void setDischarge_date(Date discharge_date) {
//        this.discharge_date = discharge_date;
//    }
//
//    public String getDischarged_by() {
//        return discharged_by;
//    }
//
//    public void setDischarged_by(String discharged_by) {
//        this.discharged_by = discharged_by;
//    }
}

