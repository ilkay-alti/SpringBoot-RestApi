package com.ilkayalti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilkayalti.model.UpdateUserRequest;
import com.ilkayalti.model.User;
import com.ilkayalti.services.UserService;

@RestController
@RequestMapping(path = "/rest-api") // kök adres
public class RestUserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/list")
    public List<User> getAllUsersList() {

        return userService.getAllUsersList();

    }

    @GetMapping(path = "/list/{id}")
    public User getUserById(@PathVariable(name = "id", required = true) String id) {
        System.out.println(id); // pathVariable ile pathdeki değeri alıyoruz
        return userService.getUserById(id);
    }

    @GetMapping(path = "/with-params")
    public List<User> getUserWithParams(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName) {

        return userService.getUsersWithParams(firstName, lastName);
    }

    @PostMapping(path = "/add-user")
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @DeleteMapping(path = "/delete-user/{id}")
    public boolean deleteUser(@PathVariable(name = "id", required = true) String userID) {
        return userService.deleteUser(userID);
    }

    // Update User
    @PutMapping(path = "/update-user/{id}")
    public User updateUser(@PathVariable(name = "id", required = true) String userID,
            @RequestBody UpdateUserRequest request) {
        return userService.updateUser(userID, request);
    }
}
