package com.example.languageservice.repository;

import com.example.languageservice.dao.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByName(String name);
}
