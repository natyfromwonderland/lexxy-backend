package com.example.lessonservice.controller;

import com.example.lessonservice.dto.LessonDTO;
import com.example.lessonservice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/app/lesson")
@CrossOrigin(origins = "*")
public class LessonController {
    @Autowired
    LessonService lessonService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LessonDTO> getAllLessons() { return lessonService.getAllLessons(); }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonDTO getById(@PathVariable("id") Long id) throws ParseException {
        return lessonService.getById(id);
    }

    @GetMapping("/lang/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonDTO> getByLangId(@PathVariable("id") Long id) throws ParseException {
        return lessonService.getAllLessonsByLang(id);
    }
}
