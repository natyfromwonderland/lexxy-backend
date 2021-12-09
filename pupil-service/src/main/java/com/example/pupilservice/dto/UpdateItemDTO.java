package com.example.pupilservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateItemDTO {
    private Long id;
    private String name;
    private byte[] content;
    private double price;
}
