package com.example.pupilservice.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String email;
    private String username;

    @OneToOne
    @JoinColumn(name = "avatarId")
    Avatar avatar;

    private double level;
    private double coins;



    public Pupil(String email) {
        this.email = email;
        this.username = "";
        this.level = 0;
        this.coins = 0;
    }

    public double updateLevel(){
        return this.level +=1;
    }

    public double increaseCoins(double amount){
        return this.coins=this.coins+amount;
    }

    public double decreaseCoins(double amount){
        if(this.coins>amount) {
            return this.coins = this.coins - amount;
        } else {
            throw new IllegalArgumentException("Not enough coins");
        }
    }



}
