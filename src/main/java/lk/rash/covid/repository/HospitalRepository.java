package lk.rash.covid.repository;

import lk.rash.covid.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,String> {
}
