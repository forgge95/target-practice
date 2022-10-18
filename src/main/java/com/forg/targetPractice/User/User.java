package com.forg.targetPractice.User;

import javax.persistence.*;
 
@Entity
@Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(name = "login", nullable = false, length = 20)
    private String login;

     
    public String getEmail() {
        return email;
    }
    public String getLogin() {
        return login;
    }
    public Long getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
