package com.ilkayalti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilkayalti.model.UpdateUserRequest;
import com.ilkayalti.model.User;
import com.ilkayalti.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsersList() {
        return userRepository.getAllUsersList();
    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public List<User> getUsersWithParams(String firsName, String lastName) {

        return userRepository.getUsersWithParams(firsName, lastName);
    }

    public User createUser(User newUser) {
        return userRepository.createUser(newUser);
    }

    public boolean deleteUser(String UserID) {
        return userRepository.deleteUser(UserID);
    }

    public User updateUser(String userID, UpdateUserRequest request) {
        return userRepository.updateUser(userID, request);
    }

}
