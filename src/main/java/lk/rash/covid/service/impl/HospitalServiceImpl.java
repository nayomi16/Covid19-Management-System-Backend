package lk.rash.covid.service.impl;

import lk.rash.covid.dto.HospitalDto;
import lk.rash.covid.entity.Hospital;
import lk.rash.covid.repository.HospitalRepository;
import lk.rash.covid.service.HospitalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

@Autowired
    HospitalRepository repository;
@Autowired
    ModelMapper mapper;
    @Override
    public void add(HospitalDto hospitalDto) {

        Hospital hospital = mapper.map(hospitalDto, Hospital.class);
        repository.save(hospital);
    }


}
