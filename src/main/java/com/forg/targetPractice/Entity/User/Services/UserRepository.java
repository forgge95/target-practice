package com.forg.targetPractice.Entity.User.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.forg.targetPractice.Entity.User.Model.User;

public interface UserRepository extends JpaRepository < User, Long > {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    public User findByLogin(String login);
    @Modifying
    @Query(value = "update users u set u.highscore = :highscore where u.id = :id", nativeQuery = true)
    public void setHighscore(@Param(value = "highscore") long highscore, @Param(value = "id") long id);
}