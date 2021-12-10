package com.example.lessonservice.dao;


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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double points;
    private Long langId;

    public Lesson(String name, double points, Long langId) {
        this.name = name;
        this.points = points;
        this.langId = langId;
    }
}
