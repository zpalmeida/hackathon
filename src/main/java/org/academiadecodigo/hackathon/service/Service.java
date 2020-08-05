package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
