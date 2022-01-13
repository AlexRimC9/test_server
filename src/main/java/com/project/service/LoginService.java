package com.project.service;

import com.project.domain.User;
import com.project.exp.LoginFailExp;
import com.project.repository.UserRepository;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Random;

@Service
public class LoginService {

    private final UserRepository userRepository;
    HttpPost post = new HttpPost();

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String login, String password) throws LoginFailExp {
        User user = userRepository.findLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return getToken(login);
        } else
            throw new LoginFailExp();
    }


    public String getToken(String login) {
        User user = userRepository.findLogin(login);
        String token = getRandomString(62);
        userRepository.
        userRepository.getTokenList().put(user.getLogin(), token);


        return token;
    }


    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();


    }
}


