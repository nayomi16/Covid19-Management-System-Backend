package lk.rash.covid.service;

import lk.rash.covid.dto.HospitalCount;
import lk.rash.covid.dto.HospitalDto;
import lk.rash.covid.entity.PatientQueue;

import java.util.List;

public interface MohService {
    void add(HospitalDto hospitalDto);


    List<PatientQueue> getQueueDetails();

    List<HospitalCount> getBedDetails();

    boolean updateQueue(String hospitalId);
}
