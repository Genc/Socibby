package com.socibby.repository;

import com.socibby.model.User;

public interface UserRepository {

    void insertUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User validateUser(String username, String password);

}
