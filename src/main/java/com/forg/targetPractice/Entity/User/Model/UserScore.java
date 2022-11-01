package com.forg.targetPractice.Entity.User.Model;

public class UserScore {
    private long score;
    private long id;

    public UserScore(long score, long id){
        this.id = id;
        this.score = score;
    }

    public long getScore() {
        return score;
    }
    public void setScore(long score) {
        this.score = score;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
