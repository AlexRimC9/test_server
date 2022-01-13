package com.project.repository;

import com.project.domain.User;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public class UserRepository {

    private  List<User> userList = new ArrayList<>();
    private  Map<Object,String> tokenList = new HashMap<>();



    public UserRepository() {
        User userOne = new User();
        userOne.setId(1L);
        userOne.setLogin("userOne");
        userOne.setPassword("123");
        userOne.setFirstName("userOne");
        userOne.setLastName("userOne");
        userOne.setAge(18);
        userOne.setToken("");
        userList.add(userOne);

        User userTwo = new User();
        userTwo.setId(2L);
        userTwo.setLogin("userTwo");
        userTwo.setPassword("123");
        userTwo.setFirstName("userTwo");
        userTwo.setLastName("userTwo");
        userTwo.setAge(20);
        userTwo.setToken("");
        userList.add(userTwo);

        User userTre = new User();
        userTre.setId(3L);
        userTre.setLogin("userTre");
        userTre.setPassword("124");
        userTre.setFirstName("userTRE");
        userTre.setLastName("userTRE");
        userTre.setAge(24);
        userTre.setToken("");
        userList.add(userTre);
    }

    public void add(User user) {
        userList.add(user);
    }

    public void update(User user) {
        Optional<User> findUser = userList.stream().filter(u -> u.getId().equals(user.getId())).findFirst();
        if (findUser.isPresent()) {
            userList.remove(findUser.get());
            userList.add(user);
        }
    }

    public void delete(Long id) {
        Optional<User> findUser = userList.stream().filter(u -> u.getId().equals(id)).findFirst();
        findUser.ifPresent(user -> userList.remove(user));
    }

    public List<User> getAllUsers() {
        return userList;

    }
    public  Map<Object,String> getTokenList() {
        return tokenList;
    }



    public  User findLogin(String login) {
        Optional<User> findUser = userList.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        return findUser.orElse(null);
    }



}
