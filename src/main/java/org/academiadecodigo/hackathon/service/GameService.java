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
    private BlackListFactory blackListFactory;
    private HashMap<Player, BlackList> blackLists = new HashMap<>();

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

    private void randomizer(List<Player> players, HashMap<Player, BlackList> blackLists) {

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

            blackLists.put(player, blackListFactory.createBlackList(weapon, crimeScene));
        }
    }

    public Map<Player, BlackList> setVictims () {

        randomizer(players, blackLists);

        int i = 0;
        blackLists.forEach((player, blackList) -> {
            blackList.setVictim(players.get(i).getUsername());
            i++;
        });

        blackLists.get(blackLists.size() - 1).setVictim(blackLists.get(0).getPlayer().getUsername());

        return blackLists;
    }

/*
    public void randomizer() {

        List victims = getVictims();
        List weapons = getMockWeapons();
        List crimeScenes = getMockCrimeScenes();

        for (Player player : players) {

            int rand1 = (int) Math.random() * victims;
            int rand2;
            int rand3;

            while (player.equals(victims.get(rand1))) {

                blackListFactory.createBlackList(victims.remove(rand1), weapons.remove(rand2), crimeScenes.remove(rand3));

                rand
            }
        }
    }*/
}
