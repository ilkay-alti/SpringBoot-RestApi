package com.ilkayalti.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ilkayalti.model.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> usersList() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("1", "ilkay", "altinisik"));
        usersList.add(new User("2", "seda", "altinisik"));
        usersList.add(new User("3", "aila", "altinisik"));
        usersList.add(new User("4", "ayten", "altinisik"));
        usersList.add(new User("5", "murat", "altinisik"));
        usersList.add(new User("6", "sude", "altinisik"));

        return usersList;
    }
}