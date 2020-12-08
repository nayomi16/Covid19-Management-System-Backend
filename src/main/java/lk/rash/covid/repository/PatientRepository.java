package lk.rash.covid.repository;

import lk.rash.covid.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

    @Query(value = "select count(id) from patient where discharge_date is null",nativeQuery = true)
    int getDischargedCases();
    @Query(value = "select count(id) from patient where discharge_date is not null",nativeQuery = true)
    int getActiveCases();
    @Modifying
    @Query(value = "update patient set severity_level= :severityLevel, admit_date= :admittedDate, admitted_by= :doctorId where id= :patientId", nativeQuery = true)
    int upadatePatient( @Param("patientId") String patientId,@Param("doctorId") String doctorId, @Param("severityLevel") String severityLevel, @Param("admittedDate") Date admittedDate);
    @Modifying
    @Query(value = "update patient set discharge_date= :dischargeDate, discharged_by= :dischargeBy where id= :patientId", nativeQuery = true)
    int upadatePatientDis(@Param("patientId") String patientId,@Param("dischargeBy") String dischargeBy,@Param("dischargeDate") Date dischargeDate);
}

