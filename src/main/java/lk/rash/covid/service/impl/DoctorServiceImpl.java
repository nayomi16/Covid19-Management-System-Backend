package lk.rash.covid.service.impl;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.entity.Doctor;
import lk.rash.covid.repository.DoctorRepository;
import lk.rash.covid.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository repo;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void save(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        repo.save(doctor);
    }

    @Override
    public boolean isDirector(String username) {
        System.out.println(username);
        Doctor isDirector = repo.getDoctor(username).get();
        System.out.println(isDirector.isDirector());
        if(isDirector!=null){
            return true;
        }else return false;

    }
}
