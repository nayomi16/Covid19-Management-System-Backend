package lk.rash.covid.service;

import lk.rash.covid.dto.PatientDto;

public interface PatientService {
    void save(PatientDto patientDto);

    int activeCasesCount();
    int dischargedCasesCount();



//    void getPatientCount();
}
