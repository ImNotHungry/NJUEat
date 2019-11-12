package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appraise")
@Getter
@Setter
public class Appraise implements Serializable {
    //自增id
    @Id
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用户id
    @Column(name = "user_id", nullable = false, length = 11)
    private int userId;

    //菜品id
    @Column(name = "dish_id", nullable = false, length = 11)
    private int dishId;

    //评分
    @Column(name = "score", nullable = false, length = 11)
    private int score;

    //评论
    @Lob
    @Column(name = "comment", columnDefinition = "longtext")
    private String comment;

    public Appraise() {
    }

    public Appraise(int id, int userId, int dishId, int score, String comment) {
        this.id = id;
        this.userId = userId;
        this.dishId = dishId;
        this.score = score;
        this.comment = comment;
    }
}
