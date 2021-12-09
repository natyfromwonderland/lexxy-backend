package com.example.pupilservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LearningDTO {

    private long id;

    private Long langId;
    private Long pupilId;

    public LearningDTO(Long langId, Long pupilId) {
        this.langId = langId;
        this.pupilId = pupilId;
    }
}
