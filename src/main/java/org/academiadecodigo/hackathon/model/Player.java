package org.academiadecodigo.hackathon.model;

public class Player {

    private String username;
    private BlackList blackList;
    private Boolean dead = false;
    private Integer kills = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BlackList getBlackList() {
        return blackList;
    }

    public void setBlackList(BlackList blackList) {
        this.blackList = blackList;
    }

    public Boolean isDead() {
        return dead;
    }

    public void kill() {
        dead = true;
    }

    public Integer getKills() {
        return kills;
    }

    public void addKill() {
        kills += 1;
    }
}
