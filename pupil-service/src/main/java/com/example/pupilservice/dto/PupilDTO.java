package com.example.pupilservice.dto;

import com.example.pupilservice.dao.Avatar;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PupilDTO {
    private long id;
    private String email;
    private String username;
    private String avatarId;
    private double level;
    private double coins;


    public PupilDTO(String email) {
        this.email = email;
        this.username = "";
        this.level = 0;
        this.coins = 0;
    }


}
