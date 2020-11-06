package lk.rash.covid.service.impl;

import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.entity.Patient;
import lk.rash.covid.repository.PatientRepository;
import lk.rash.covid.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository repository;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public void save(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        repository.save(patient);
    }

    @Override
    public int activeCasesCount() {
        repository.getActiveCases();

        return repository.getActiveCases();
    }

    @Override
    public int dischargedCasesCount() {
        return repository.getDischargedCases();
    }

    @Override
    public Boolean updatePatient(String patient_id, String severity_level, Date admite_date, String admitted_by) {
        int i=repository.upadatePatient(patient_id,severity_level,admite_date,admitted_by);
        if(i>1) return true;
        else return false;
    }

//    @Override
//    public void getPatientCount() {
//        repository.getPatientCount();
//    }

}