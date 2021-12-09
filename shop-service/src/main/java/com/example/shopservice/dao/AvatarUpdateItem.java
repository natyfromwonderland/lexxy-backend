package com.example.shopservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvatarUpdateItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] content;
    private String name;

    private double price;

    public AvatarUpdateItem(byte[] content, String name, double price) {
        this.content = content;
        this.name = name;
        this.price = price;
    }

    public AvatarUpdateItem(byte[] content) {
        this.content = content;
    }
}
