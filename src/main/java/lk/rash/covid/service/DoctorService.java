package lk.rash.covid.service;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.dto.DoctorHosDto;
import lk.rash.covid.response.HospitaBedResponse;

import java.util.List;

public interface DoctorService {
    void save(DoctorDto doctorDto);

    boolean isDirector(String username);

    HospitaBedResponse getBedList(String username);

    List<DoctorHosDto> getDocters(String hospitalId);

    List<DoctorHosDto> getAllDocters();
}
