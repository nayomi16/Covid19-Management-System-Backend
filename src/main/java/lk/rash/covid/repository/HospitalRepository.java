package lk.rash.covid.repository;

import lk.rash.covid.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,String> {
    @Query(value = "select * from hospital where id =:hos_id",nativeQuery = true)
    Hospital getHospital(@Param("hos_id") String hos_id);
}
