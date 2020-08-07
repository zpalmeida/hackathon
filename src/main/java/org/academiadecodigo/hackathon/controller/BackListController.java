package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.model.BlackList;
import org.academiadecodigo.hackathon.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/blacklist")
public class BackListController {

    private GameService gameService;

    @Autowired
    public void setBlackListService(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/weapons")
    public ResponseEntity<?> addObjects(@Valid @RequestBody List<String> weapons, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        gameService.setWeapons(weapons);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/crime-scenes")
    public ResponseEntity<?> addRooms(@Valid @RequestBody List<String> crimeScenes, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        gameService.setCrimeScenes(crimeScenes);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{username}")
    public ResponseEntity<BlackList> sendBlackList(@PathVariable String username) {

        if (gameService.findPlayerByUsername(username) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!gameService.isGameStarted()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        gameService.setVictims();

        return new ResponseEntity<>(gameService.getBlackList(gameService.findPlayerByUsername(username)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{kUsername}/{vUsername}")
    public ResponseEntity<BlackList> sendBlackList(@PathVariable String kUsername, @PathVariable String vUsername) {

        if (gameService.findPlayerByUsername(kUsername) == null || gameService.findPlayerByUsername(vUsername) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!gameService.findPlayerByUsername(vUsername).isDead()) {
            return null;
        }

        gameService.findPlayerByUsername(kUsername).addKill();

        return new ResponseEntity<>(gameService.getBlackList(gameService.findPlayerByUsername(vUsername)), HttpStatus.OK);
    }
}
