package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.factory.BlackListFactory;
import org.academiadecodigo.hackathon.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public  List<Player> getVictims() {

        List<Player> victims = new ArrayList<>();

        victims.addAll(players);

        return victims;
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
    }
}
