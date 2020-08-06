package org.academiadecodigo.hackathon.converter;

import org.academiadecodigo.hackathon.model.Player;
import org.academiadecodigo.hackathon.model.dto.PlayerDto;
import org.springframework.stereotype.Service;

@Service
public class PlayerToPlayerDto {

    public PlayerDto converter(Player player) {

        PlayerDto playerDto = new PlayerDto();

        playerDto.setUsername(player.getUsername());

        return playerDto;
    }
}
