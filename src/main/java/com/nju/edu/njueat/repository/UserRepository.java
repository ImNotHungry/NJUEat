package com.nju.edu.njueat.repository;

import com.nju.edu.njueat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
