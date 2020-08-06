package org.academiadecodigo.hackathon.converter;

import org.academiadecodigo.hackathon.model.Player;
import org.academiadecodigo.hackathon.model.dto.PlayerDto;

public class PlayerDtoToPlayer {

    public Player convert(PlayerDto playerDto) {

        Player player = new Player();
        player.setUsername(playerDto.getUsername());

        return player;
    }
}
