package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converter.PlayerDtoToPlayer;
import org.academiadecodigo.hackathon.converter.PlayerToPlayerDto;
import org.academiadecodigo.hackathon.model.Player;
import org.academiadecodigo.hackathon.model.dto.PlayerDto;
import org.academiadecodigo.hackathon.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private GameService gameService;
    private PlayerToPlayerDto playerToPlayerDto;
    private PlayerDtoToPlayer playerDtoToPlayer;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @Autowired
    public void setPlayerToPlayerDto(PlayerToPlayerDto playerToPlayerDto) {
        this.playerToPlayerDto = playerToPlayerDto;
    }

    @Autowired
    public void setPlayerDtoToPlayer(PlayerDtoToPlayer playerDtoToPlayer) {
        this.playerDtoToPlayer = playerDtoToPlayer;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<PlayerDto>> listPlayers() {

        List<PlayerDto> playerDtos = new ArrayList<>();

        for (Player player : gameService.getPlayers()) {
            playerDtos.add(playerToPlayerDto.converter(player));
        }

        return new ResponseEntity<>(playerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addPlayer(@Valid @RequestBody PlayerDto playerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || playerDto.getUsername() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        gameService.addPlayer(playerDtoToPlayer.convert(playerDto));

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
