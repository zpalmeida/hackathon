package org.academiadecodigo.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String home() {
        return "startMenu";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/authentication")
    public String chooseUsernameAndGameRoom() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/choose-username")
    public String chooseUsername() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/objects")
    public String pickObjects() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rooms")
    public String setRooms() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/game-start")
    public String startingPage() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/waiting-room")
    public String waitingPage() {
        return "";
    }
}
