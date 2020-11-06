package lk.rash.covid.repository;

import lk.rash.covid.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

    @Query(value = "select count(id) from patient where discharge_date is null",nativeQuery = true)
    int getDischargedCases();
    @Query(value = "select count(id) from patient where discharge_date is not null",nativeQuery = true)
    int getActiveCases();

    @Query(value = "update patient set severity_level=severity_level, admite_date=admite_date, admitted_by=admitted_by where patient_id=patient_id", nativeQuery = true)
    int upadatePatient(String patient_id, String severity_level, Date admite_date, String admitted_by);
}

