package com.example.pupilservice.repository;

import com.example.pupilservice.dao.Learning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningRepository extends JpaRepository<Learning, Long> {

    List<Learning> findByPupilId(Long pupilId);
    boolean existsLearningByLangIdAndPupilId (Long langId, Long pupilId);
}
