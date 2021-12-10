package com.example.languageservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
