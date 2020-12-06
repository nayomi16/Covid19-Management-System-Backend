package lk.rash.covid.service.impl;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.dto.DoctorHosDto;
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

    @Override
    public List<DoctorHosDto> getDocters(String hospitalId) {
        List<DoctorHosDto> doctorHosDtoList=new ArrayList<>();
        List<Doctor> doctors = repo.findByHosId(hospitalId);
        for (Doctor doctor :doctors)
        {
            int id=doctor.getId();
            String name=doctor.getName();
            boolean isdirector=doctor.isDirector();
            String email=doctor.getEmail();

            DoctorHosDto doctorHosDto=new DoctorHosDto(id,name,hospitalId,isdirector,email);
            doctorHosDtoList.add(doctorHosDto);
        }
        return doctorHosDtoList;
    }

    @Override
    public List<DoctorHosDto> getAllDocters() {
        List<DoctorHosDto> allDocs=new ArrayList<>();
        List<Doctor> allDoctors = repo.findAll();
        for (Doctor doctor :allDoctors)
        {
            int id=doctor.getId();
            String name=doctor.getName();
            boolean isdirector=doctor.isDirector();
            String email=doctor.getEmail();
            String hospitalId=doctor.getHospital().getId();
            DoctorHosDto doctorHosDto=new DoctorHosDto(id,name,hospitalId,isdirector,email);
            allDocs.add(doctorHosDto);
        }


        return allDocs;
    }

    @Override
    public boolean isUpdated(String hospitalId, String userName) {


        int isUpdate = repo.doctorUpdate(hospitalId, userName);
        if(isUpdate>0){
            return true;
        }else return false;

    }
}
