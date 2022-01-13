package com.project;

import com.project.domain.User;
import com.project.exp.LoginFailExp;
import com.project.repository.UserRepository;
import com.project.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private LoginService loginService;
    private  User user;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(@RequestParam String token) {
       if (ValidateToken(token)) {
            return userRepository.getAllUsers();
        }
        return null;
    }

    @PostMapping("/users/add")
    public User addUser(@RequestBody User user,@RequestParam String token) {
        if (ValidateToken(token)) {
            userRepository.add(user);
            return user;
        }
        return null;
    }

    @DeleteMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable Long id ,@RequestParam String token) {
        if (ValidateToken(token)) {
            userRepository.delete(id);

        }

    }

    public Boolean ValidateToken(String token) {
        return userRepository.getTokenList().containsValue(token);
    }
}
