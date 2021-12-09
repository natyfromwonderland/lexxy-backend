package com.example.lessonservice.service;

import com.example.lessonservice.dao.Lesson;
import com.example.lessonservice.dto.LessonDTO;
import com.example.lessonservice.repository.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    private ModelMapper modelMapper;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<LessonDTO> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<LessonDTO> getAllLessonsByLang(Long langId) {
        List<Lesson> lessons = lessonRepository.findByLangId(langId);
        return lessons.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public LessonDTO getById(Long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isPresent()) {
            return convertToDto(lesson.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Lesson with id " + id);
        }
    }

    public LessonDTO convertToDto(Lesson lesson) {
        LessonDTO lessonDTO = modelMapper.map(lesson, LessonDTO.class);
        return lessonDTO;
    }
}
