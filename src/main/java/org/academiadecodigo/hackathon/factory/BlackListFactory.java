package org.academiadecodigo.hackathon.factory;

import org.academiadecodigo.hackathon.model.BlackList;
import org.academiadecodigo.hackathon.model.Player;
import org.springframework.stereotype.Service;

@Service
public class BlackListFactory {

    public BlackList createBlackList(String object, String room) {

        BlackList blackList = new BlackList();

        blackList.setWeapon(object);
        blackList.setCrimeScene(room);

        return blackList;
    }
}
