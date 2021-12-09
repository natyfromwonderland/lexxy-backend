package com.example.pupilservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LanguageDTO {
    private long id;
    private String name;

    public LanguageDTO(String name) {
        this.name = name;
    }
}
