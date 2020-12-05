package lk.rash.covid.service;

import lk.rash.covid.dto.DoctorDto;

public interface DoctorService {
    void save(DoctorDto doctorDto);

    boolean isDirector(String username);
}
