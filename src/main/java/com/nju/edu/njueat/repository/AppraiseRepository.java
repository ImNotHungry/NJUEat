package com.nju.edu.njueat.repository;

import com.nju.edu.njueat.model.Appraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppraiseRepository extends JpaRepository<Appraise, Integer> {
    /**
     * 获得一个餐厅的所有评论
     * @param restaurantId 餐厅id
     * @return 评论列表
     */
    @Query(value = "select t2.name, t2.avatarUrl, t1.comment, t1.commentTime from Appraise t1 " +
            "left join User t2 on t1.userId=t2.id")
    List<Object[]> findAllAppraise();
}
