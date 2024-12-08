package com.ilkayalti.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilkayalti.model.UpdateUserRequest;
import com.ilkayalti.model.User;

@Repository
public class UserRepository {
    @Autowired
    private List<User> usersList;

    // get all users at usersList
    public List<User> getAllUsersList() {
        return usersList;
    }

    // get Users id at userList
    public User getUserById(String id) {
        User findUser = null;

        for (User user : usersList) {
            if (id.equals(user.getId())) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    // get users filter with params

    public List<User> getUsersWithParams(String firstName, String lastName) {

        List<User> findUsersWithParamsList = new ArrayList<>();

        for (User user : usersList) {
            if (firstName != null && lastName != null) {
                if (user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName)) {
                    findUsersWithParamsList.add(user);
                }
            } else if (firstName != null && lastName == null) {
                if (user.getFirstName().equalsIgnoreCase(firstName)) {
                    findUsersWithParamsList.add(user);
                }
            } else if (firstName == null && lastName != null) {
                if (user.getLastName().equalsIgnoreCase(lastName)) {
                    findUsersWithParamsList.add(user);
                }
            } else {
                if (firstName == null && lastName == null) {
                    findUsersWithParamsList.add(user);
                }
            }

        }

        return findUsersWithParamsList;

    }

    // add User

    public User createUser(User newUser) {
        usersList.add(newUser);
        return newUser;
    }

    // delete user

    public boolean deleteUser(String userID) {
        User deleteUser = null;

        for (User user : usersList) {
            if (userID.equals(user.getId())) {
                deleteUser = user;
                break;
            }
        }

        if (deleteUser != null) {

            usersList.remove(deleteUser);
            return true;
        }
        return false;
    }

    // update user

    public User updateUser(String userID, UpdateUserRequest request) {

        User deleteUser = getUserById(userID);
        if (deleteUser != null) {
            deleteUser(userID);

            User updateUser = new User();
            updateUser.setId(userID);
            updateUser.setFirstName(request.getFirstName());
            updateUser.setLastName(request.getLastName());

            usersList.add(updateUser);
            return updateUser;
        }

        return null;
    }

}
