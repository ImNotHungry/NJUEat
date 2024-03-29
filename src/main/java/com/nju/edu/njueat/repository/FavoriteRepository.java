package com.nju.edu.njueat.repository;

import com.nju.edu.njueat.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> getAllByUserId(int userId);

    Favorite getFavoriteByUserIdAndFoodId(int userId, int foodId);
}
