package lk.rash.covid.service;

import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.response.PatientResponse;

import java.sql.SQLException;
import java.util.Date;

public interface PatientService {
    PatientResponse save(PatientDto patientDto) throws SQLException, ClassNotFoundException;

    int activeCasesCount();
    int dischargedCasesCount();

    Boolean updatePatient(String patient_id, String severity_level, Date admite_date, String admitted_by);

    PatientDto getPatient(String patientId);


//    void getPatientCount();
}
