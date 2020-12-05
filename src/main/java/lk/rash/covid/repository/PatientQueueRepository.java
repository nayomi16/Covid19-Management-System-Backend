package lk.rash.covid.repository;


import lk.rash.covid.entity.PatientQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientQueueRepository extends JpaRepository<PatientQueue,Integer> {
//    @Modifying
//    @Query(value = "insert into patient_queue(patient_id) values ( :patientId)",nativeQuery = true)
//    int addToQueue(@Param("patientId") String patientId);
    @Query(value = "select id from patient_queue where patient_id = :patientId",nativeQuery = true)
    int getQueueNo(@Param("patientId") String patientId);
}
