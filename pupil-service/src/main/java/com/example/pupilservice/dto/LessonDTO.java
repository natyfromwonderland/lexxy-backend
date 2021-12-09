package com.example.pupilservice.dto;

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
    private double points;
    private Long langId;

    public LessonDTO(double points, Long langId) {
        this.points = points;
        this.langId = langId;
    }
}
