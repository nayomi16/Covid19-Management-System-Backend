package lk.rash.covid.repository;

import lk.rash.covid.entity.HospitalBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalBedRepository extends JpaRepository<HospitalBed,Integer> {

    @Query(value = "select distinct hospital_id from hospital_bed where patient_id is null",nativeQuery = true)
    List<String> BedsAvailableHospitals();
    @Query(value = "select min(id) from hospital_bed where hospital_id = :finalHid and patient_id is null",nativeQuery = true)
    int getBedId(@Param("finalHid") String finalHid);

    @Query(value = "select * from hospital_bed where hospital_id= :hosId",nativeQuery = true)
    List<HospitalBed> findByHosId(@Param("hosId") String hosId);

    @Query(value = "select count(id) from hospital_bed where hospital_id = :hosId and patient_id is null",nativeQuery = true)
    int bedCount(@Param("hosId") String hosId);
    @Modifying
    @Query(value = "update hospital_bed set patient_id= :patId where hospital_id = :hospitalId and id= :bedId",nativeQuery = true)
    int updateHosBed(@Param("bedId") int bedId, @Param("hospitalId") String hospitalId,@Param("patId") String patId);
//    @Modifying
//    @Query(value = "update hospital_bed hb set hb.patient_id= :patientId where hb.id= :bedId and hb.hospital_id= :finalHid",nativeQuery = true)
//    void patientBedUpdate(@Param("finalHid") String finalHid,@Param("bedId") int bedId,@Param("patientId") String patientId);
}
