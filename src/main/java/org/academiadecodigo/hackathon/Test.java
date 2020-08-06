package org.academiadecodigo.hackathon;

import org.academiadecodigo.hackathon.model.BlackList;
import org.academiadecodigo.hackathon.model.Player;
import org.academiadecodigo.hackathon.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        GameService gameService = new GameService();
        List<String> weapons = new ArrayList<>();
        List<String> scenes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Player player = new Player();
            player.setUsername("player" + i);
            gameService.addPlayer(player);
        }

        for (int i = 0; i < 3; i++) {

            String string = "weapon" + i;
            weapons.add(string);
        }

        for (int i = 0; i < 4; i++) {

            String string = "scene" + i;
            scenes.add(string);
        }

        gameService.setWeapons(weapons);
        gameService.setCrimeScenes(scenes);

        for (Player player: gameService.getPlayers()) {

            System.out.print(player.getUsername() + " || ");
        }

        System.out.println(" ");

        List<BlackList> list = gameService.setVictims();

        for (Player player: gameService.getPlayers()) {

            System.out.print(player.getUsername() + " || ");
        }

        System.out.println(" ");

        for (BlackList lis: list) {

            System.out.print(lis.getVictim() + " " + lis.getWeapon() + " " + lis.getCrimeScene() + " || ");
        }
    }
}
