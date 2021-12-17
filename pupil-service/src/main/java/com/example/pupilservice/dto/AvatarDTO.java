package com.example.pupilservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvatarDTO {
    private Long id;
    private String name;

    public AvatarDTO(String name) {
        this.name = name;
    }
}
