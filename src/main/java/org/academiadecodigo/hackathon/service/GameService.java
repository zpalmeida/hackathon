package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.factory.BlackListFactory;
import org.academiadecodigo.hackathon.model.BlackList;
import org.academiadecodigo.hackathon.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private List<Player> players = new ArrayList<>();
    private List<String> weapons;
    private List<String> crimeScenes;
    private List<BlackList> blackLists = new ArrayList<>();
    private BlackListFactory blackListFactory = new BlackListFactory();
    private boolean gameStarted = false;

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    public void setCrimeScenes(List<String> crimeScenes) {
        this.crimeScenes = crimeScenes;
    }

    @Autowired
    public void setBlackListFactory(BlackListFactory blackListFactory) {
        this.blackListFactory = blackListFactory;
    }

    public void startGame() {
        gameStarted = true;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public BlackList getBlackList(Player player) {
        return player.getBlackList();
    }

    private List<String> getMockWeapons() {

        List<String> mockWeapons = new ArrayList<>();

        for (String weapon : weapons) {
            mockWeapons.add(weapon);
        }

        return mockWeapons;
    }

    private List<String> getMockCrimeScenes() {

        List<String> mockCrimeScenes = new ArrayList<>();

        for (String crimeScene : crimeScenes) {
            mockCrimeScenes.add(crimeScene);
        }

        return mockCrimeScenes;
    }

    private void setWeaponsAndScenes(List<BlackList> blackLists) {

        List<String> weapons = getMockWeapons();
        List<String> crimeScenes = getMockCrimeScenes();
        Collections.shuffle(players, new Random(42));

        for (Player player : players) {

            if(weapons.size() < 1) {
                weapons = getMockWeapons();
            }

            if (crimeScenes.size() < 1) {
                crimeScenes = getMockCrimeScenes();
            }

            String weapon = weapons.remove((int)(Math.random() * weapons.size()));
            String crimeScene = crimeScenes.remove((int)(Math.random() * crimeScenes.size()));

            BlackList blackList = blackListFactory.createBlackList(weapon, crimeScene);
            player.setBlackList(blackList);
            blackLists.add(blackList);
        }
    }

    public List<BlackList> setVictims() {

        setWeaponsAndScenes(blackLists);

        for (int i = 0; i < blackLists.size() - 1; i++) {

            blackLists.get(i).setVictim(players.get(i + 1).getUsername());
        }

        blackLists.get(blackLists.size() - 1).setVictim(players.get(0).getUsername());

        return blackLists;
    }

    public Player findPlayerByUsername(String username) {

        for (Player player : players) {

            if (player.getUsername().equals(username)) {
                return player;
            }
        }
        return null;
    }
}
