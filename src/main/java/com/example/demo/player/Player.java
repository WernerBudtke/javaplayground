package com.example.demo.player;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private String password;
    private Integer highscore;
    private Integer tries;
    private Integer wins;
    private Integer score;
    private Short roll;

    public Player(String username, String password, Integer highscore, Integer tries, Integer wins, Integer score, Short roll) {
        this.username = username;
        this.password = password;
        this.highscore = highscore;
        this.tries = tries;
        this.wins = wins;
        this.score = score;
        this.roll = roll;
    }

    public Player(String username, String password){
        this.username = username;
        this.password = password;
        this.highscore = 0;
        this.tries = 0;
        this.wins = 0;
        this.score = 0;
        this.roll = 5000;
    }

    public Player(){
        this.highscore = 0;
        this.tries = 0;
        this.wins = 0;
        this.score = 0;
        this.roll = 5000;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getTries() {
        return tries;
    }

    public void setTries(Integer tries) {
        this.tries = tries;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Short getRoll() {
        return roll;
    }

    public void setRoll(Short roll) {
        this.roll = roll;
    }
}
