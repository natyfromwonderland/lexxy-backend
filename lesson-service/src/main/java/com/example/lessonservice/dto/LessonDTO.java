package com.example.lessonservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonDTO {

    private long id;
    private String name;
    private double points;
    private Long langId;

    public LessonDTO(String name, double points, Long langId) {
        this.name = name;
        this.points = points;
        this.langId = langId;
    }
}
