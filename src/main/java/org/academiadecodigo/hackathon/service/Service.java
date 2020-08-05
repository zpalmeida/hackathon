package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
