package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    private List<User> users = new ArrayList();

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<User>> listUsers() {

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();

        user1.setUsername("Paulo");
        user2.setUsername("Zé Pedro");
        user3.setUsername("Leonor");
        user4.setUsername("Edu");
        user5.setUsername("Andreia");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || user.getUsername() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        users.add(user);

        UriComponents uriComponents = uriComponentsBuilder.path("").build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
/*
    @RequestMapping(method = RequestMethod.POST, path = "api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody CustomerDto customerDto){
        Customer customer = customerDtoToCustomer.convert(customerDto);
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }*/
}