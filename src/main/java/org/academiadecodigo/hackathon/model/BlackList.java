package org.academiadecodigo.hackathon.model;

public class BlackList {

    private Player player;
    private String victim;
    private String weapon;
    private String crimeScene;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getCrimeScene() {
        return crimeScene;
    }

    public void setCrimeScene(String crimeScene) {
        this.crimeScene = crimeScene;
    }
}
