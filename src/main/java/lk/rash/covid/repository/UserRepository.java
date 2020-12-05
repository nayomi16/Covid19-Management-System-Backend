package lk.rash.covid.repository;

import lk.rash.covid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where user_name =:name", nativeQuery = true)
    Optional<User> findByUsername(@Param("name") String name);

}
