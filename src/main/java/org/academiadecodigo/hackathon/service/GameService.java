package org.academiadecodigo.hackathon.service;

import jdk.jfr.internal.PlatformEventType;
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
    private BlackListFactory blackListFactory;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public BlackList getBlackList(Player player) {
        return player.getBlackList();
    }

    public List<String> getMockWeapons() {

        List<String> mockWeapons = new ArrayList<>();

        mockWeapons.addAll(weapons);

        return mockWeapons;
    }

    public List<String> getMockCrimeScenes() {

        List<String> mockCrimeScenes = new ArrayList<>();

        mockCrimeScenes.addAll(crimeScenes);

        return mockCrimeScenes;
    }

    private void randomizer(List<Player> players, List<BlackList> blackLists) {

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

            String weapon = weapons.remove((int)(Math.random() * (crimeScenes.size() + 1)));
            String crimeScene = crimeScenes.remove((int)(Math.random() * (crimeScenes.size() + 1)));

            BlackList blackList = new BlackList();
            blackList.setWeapon(weapon);
            blackList.setCrimeScene(crimeScene);

            player.setBlackList(blackList);
            blackLists.add(blackList);
        }
    }

    public List<String> setVictims () {

        for (Player player : players) {


        }
    }
}
