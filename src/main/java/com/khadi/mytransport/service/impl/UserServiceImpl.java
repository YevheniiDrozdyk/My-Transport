package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.model.User;
import com.khadi.mytransport.repository.UserRepository;
import com.khadi.mytransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String phoneNumber, String password) {
        return false;
    }

    @Override
    public void register(User user) {

    }

    @Override
    public boolean isExist(String phoneNumber) {
        return false;
    }

    @Override
    public User get(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User get(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElse(new User());
    }
}
