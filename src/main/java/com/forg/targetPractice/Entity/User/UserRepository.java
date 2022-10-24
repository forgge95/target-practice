package com.forg.targetPractice.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    public User findByLogin(String login);
}
