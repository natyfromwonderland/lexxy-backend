package com.example.pupilservice.proxy;

import com.example.pupilservice.dto.LessonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("LESSON-SERVICE")
public interface LessonServiceProxy {

    @GetMapping("/app/lesson")
    List<LessonDTO> getAllLessons();


    @GetMapping("/app/lesson/id")
    LessonDTO getById(@PathVariable("id") Long id);
}
