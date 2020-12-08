package lk.rash.covid.service.impl;

import lk.rash.covid.dto.HospitalCount;
import lk.rash.covid.dto.HospitalDto;
import lk.rash.covid.entity.Hospital;
import lk.rash.covid.entity.Patient;
import lk.rash.covid.entity.PatientQueue;
import lk.rash.covid.repository.HospitalBedRepository;
import lk.rash.covid.repository.HospitalRepository;
import lk.rash.covid.repository.PatientQueueRepository;
import lk.rash.covid.service.MohService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MohServiceImpl implements MohService {

@Autowired
    HospitalRepository repository;
@Autowired
    PatientQueueRepository patientQueueRepository;
@Autowired
    ModelMapper mapper;
@Autowired
    HospitalBedRepository bedRepository;
    @Override
    public void add(HospitalDto hospitalDto) {

        Hospital hospital = mapper.map(hospitalDto, Hospital.class);
        repository.save(hospital);
    }

    @Override
    public List<PatientQueue> getQueueDetails() {
        List<PatientQueue> queueDetails = patientQueueRepository.findAll();
        return queueDetails;
    }

    @Override
    public List<HospitalCount> getBedDetails() {
        List<HospitalCount> hospitalCounts=new ArrayList<>();
        List<Hospital> allHospital = repository.findAll();
        for (Hospital h:allHospital) {
            int bedCount = bedRepository.bedCount(h.getId());
            hospitalCounts.add(new HospitalCount(h.getId(),h.getName(),h.getDistrict(),bedCount,h.getLocation_x(),h.getLocation_y()));

        }
        return hospitalCounts;
    }

    @Override
    public boolean updateQueue(String hospitalId) {
        List<PatientQueue> patientQueueList = patientQueueRepository.findAll();
        for (PatientQueue p : patientQueueList) {
            int bedId=bedRepository.getBedId(hospitalId);
            int isUpdated = bedRepository.updateHosBed(bedId, hospitalId, p.getPatient().getId());
            System.out.println(isUpdated+"- isUpdated");
        }

        patientQueueRepository.deleteAll();
        if(patientQueueList.isEmpty()){
            return true;
        }else return false;

    }


}
