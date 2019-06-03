package com.socibby.service;

import com.socibby.model.User;

public interface UserService {

    void insertUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User validateUser(String username, String password);
}
