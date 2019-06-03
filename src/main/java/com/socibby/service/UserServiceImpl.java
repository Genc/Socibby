package com.socibby.service;

import com.socibby.model.User;
import com.socibby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public User validateUser(String username, String password) {
        return userRepository.validateUser(username, password);
    }
}
