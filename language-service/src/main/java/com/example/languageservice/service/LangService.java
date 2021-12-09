package com.example.languageservice.service;

import com.example.languageservice.dao.Language;
import com.example.languageservice.dto.LanguageDTO;
import com.example.languageservice.repository.LanguageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LangService {
    private final LanguageRepository languageRepository;
    @Autowired
    private ModelMapper modelMapper;

    public LangService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageDTO> getAllLangs() {
        List<Language> langs = languageRepository.findAll();
        return langs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public LanguageDTO getById(Long id) {
        Optional<Language> language = languageRepository.findById(id);
        if (language.isPresent()) {
            return convertToDto(language.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Language with id " + id);
        }
    }

    public LanguageDTO convertToDto(Language language) {
        LanguageDTO languageDTO = modelMapper.map(language, LanguageDTO.class);
        return languageDTO;
    }
}
