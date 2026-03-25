package org.example.amazonclone.controller;

import org.example.amazonclone.service.UserService;
import org.example.amazonclone.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,
                        @RequestParam String password) {

        return userService.loginUser(email, password);
    }
}
