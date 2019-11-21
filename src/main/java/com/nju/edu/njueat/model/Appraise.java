package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    //餐馆id
    @Column(name = "restaurant_id", nullable = false, length = 11)
    private int restaurantId;

    //评论
    @Lob
    @Column(name = "comment", columnDefinition = "longtext")
    private String comment;

    //评论时间
    @Column(name = "comment_time", nullable = false)
    private LocalDateTime commentTime;

    public Appraise() {
    }

    public Appraise(int id, int userId, int restaurantId, String comment, LocalDateTime commentTime) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.comment = comment;
        this.commentTime = commentTime;
    }
}
