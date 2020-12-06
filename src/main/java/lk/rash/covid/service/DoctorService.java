package lk.rash.covid.service;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.response.HospitaBedResponse;

public interface DoctorService {
    void save(DoctorDto doctorDto);

    boolean isDirector(String username);

    HospitaBedResponse getBedList(String username);
}
