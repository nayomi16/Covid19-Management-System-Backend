package lk.rash.covid.repository;

import lk.rash.covid.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
}
