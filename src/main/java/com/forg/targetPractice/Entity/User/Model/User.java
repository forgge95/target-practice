package com.forg.targetPractice.Entity.User.Model;

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

    @Column(name = "highscore", nullable = true)
    private long highscore;
    @Transient
    private String validation;
    public String getValidation() {
        return validation;
    }
    public void setValidation(String validation) {
        this.validation = validation;
    }
    public long getHighscore() {
        return highscore;
    }
    public void setHighscore(long highscore) {
        this.highscore = highscore;
    }
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
    @Override
    public String toString() {
        return "[" + getId() + "; " + getEmail() + "; " + getLogin() + "; " + getHighscore() + " | "+getValidation()+"]";
    }
    @Override
    public int hashCode() {
        return getId().hashCode() + getLogin().hashCode() + getEmail().hashCode();
    }
    @Override
    public boolean equals(Object arg0) {
        return getLogin().equals(arg0) && getEmail().equals(arg0);
    }
}