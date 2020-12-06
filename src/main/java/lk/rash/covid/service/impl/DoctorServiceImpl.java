package lk.rash.covid.service.impl;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.dto.HospitalBedRespDto;
import lk.rash.covid.entity.Doctor;
import lk.rash.covid.entity.Hospital;
import lk.rash.covid.entity.HospitalBed;
import lk.rash.covid.entity.Patient;
import lk.rash.covid.repository.DoctorRepository;
import lk.rash.covid.repository.HospitalBedRepository;
import lk.rash.covid.repository.PatientRepository;
import lk.rash.covid.response.HospitaBedResponse;
import lk.rash.covid.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository repo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    HospitalBedRepository hospitalBedRepository;

    @Autowired
    PatientRepository patientRepository;
    @Override
    public void save(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        repo.save(doctor);
    }

    @Override
    public boolean isDirector(String username) {
        System.out.println(username);
        int isDirector = repo.isDirector(username);

        if(isDirector>0){
            return true;
        }else return false;

    }

    @Override
    public HospitaBedResponse getBedList(String username) {
        Doctor doctor = repo.getDoctor(username).get();
        Hospital hospital=doctor.getHospital();
        String hosId=hospital.getId();
        String hosName=hospital.getName();

        List<HospitalBedRespDto> hospitalBedRespDtos =new ArrayList<>();
        List<HospitalBed> hospitalBed = hospitalBedRepository.findByHosId(hosId);
        for (HospitalBed hospitalBed1:hospitalBed)
            {
                if(hospitalBed1.getPatient()!=null){

                    Patient patient = patientRepository.findById(hospitalBed1.getPatient().getId()).get();

                  System.out.println(patient.getId()+" id");

                    HospitalBedRespDto hospitalBedRespDto=new HospitalBedRespDto(hospitalBed1.getHospitalBedPK().getId(),hospitalBed1.getPatient().getId(),patient.getAddmitedBy()!=null,patient.getDischargeBy()!=null);
                    hospitalBedRespDtos.add(hospitalBedRespDto);
                }


            }
            if(hospitalBedRespDtos!=null){
                return new HospitaBedResponse(hosId,hosName,hospitalBedRespDtos);
            }else return new HospitaBedResponse(hosId,hosName,null);


    }
}
