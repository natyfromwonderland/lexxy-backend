package com.example.pupilservice.repository;

import com.example.pupilservice.dao.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long> {

    Optional<Pupil> findById(Long aLong);

    Optional<Pupil> findByUsername (String username);

    Optional<Pupil> findByEmail (String email);

    @Query(value = "SELECT * FROM pupil p ORDER BY p.coins DESC LIMIT 10", nativeQuery = true)
    List<Pupil> findTopTen();
}
