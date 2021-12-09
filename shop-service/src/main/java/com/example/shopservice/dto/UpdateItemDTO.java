package com.example.shopservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

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
