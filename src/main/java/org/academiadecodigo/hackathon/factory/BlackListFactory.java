package org.academiadecodigo.hackathon.factory;

import org.academiadecodigo.hackathon.model.BlackList;
import org.academiadecodigo.hackathon.model.Player;
import org.springframework.stereotype.Service;

@Service
public class BlackListFactory {

    public BlackList createBlackList(Player victim, String object, String room) {

        BlackList blackList = new BlackList();

        blackList.setVictim(victim.getUsername());
        blackList.setWeapon(object);
        blackList.setCrimeScene(room);

        return blackList;
    }
}
