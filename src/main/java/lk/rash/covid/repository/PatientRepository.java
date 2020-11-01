package lk.rash.covid.repository;

import lk.rash.covid.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient,String> {

    @Query(value = "select count(id) from patient where discharge_date is null",nativeQuery = true)
    int getDischargedCases();
    @Query(value = "select count(id) from patient where discharge_date is not null",nativeQuery = true)
    int getActiveCases();

}
