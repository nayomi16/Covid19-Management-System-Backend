package lk.rash.covid.service;

import lk.rash.covid.dto.HospitalPatient;
import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.response.PatientResponse;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface PatientService {
    PatientResponse save(PatientDto patientDto) throws SQLException, ClassNotFoundException;

    int activeCasesCount();
    int dischargedCasesCount();

    Boolean updatePatient(String patientId, String doctorId, String severity_level, Date date, String role);

    PatientDto getPatient(String patientId);

    List<HospitalPatient> getPatientCount();

    List<PatientDto> getAllPatients();


//    void getPatientCount();
}
