package org.example.amazonclone.service;

import org.example.amazonclone.model.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);
}
