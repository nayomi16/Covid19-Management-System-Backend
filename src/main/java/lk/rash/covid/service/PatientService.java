package lk.rash.covid.service;

import lk.rash.covid.dto.PatientDto;

import java.util.Date;

public interface PatientService {
    void save(PatientDto patientDto);

    int activeCasesCount();
    int dischargedCasesCount();

    Boolean updatePatient(String patient_id, String severity_level, Date admite_date, String admitted_by);


//    void getPatientCount();
}
