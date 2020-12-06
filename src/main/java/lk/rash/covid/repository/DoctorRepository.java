package lk.rash.covid.repository;

import lk.rash.covid.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
//    @Query(value = "select  is_director from doctor where user_name= :username",nativeQuery = true)
//    Integer isDirector(@Param("username") String username);

    @Query(value = "select is_director from doctor where user_name =:username",nativeQuery = true)
    int isDirector(@Param("username") String username);
    @Query(value = "select * from doctor where user_name =:username",nativeQuery = true)
    Optional<Doctor> getDoctor(@Param("username") String username);
    @Query(value = "select * from doctor where hospital_id = :hospitalId",nativeQuery = true)
    List<Doctor> findByHosId(@Param("hospitalId") String hospitalId);
    @Modifying
    @Query(value = "update doctor set hospital_id= :hospitalId, is_director= true where user_name = :username",nativeQuery = true)
    int doctorUpdate(@Param("hospitalId") String hospitalId,@Param("username") String username);
}
