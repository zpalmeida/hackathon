package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class Controller {

    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<User>> listUsers() {

        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || user.getUsername() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.addUser(user);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
