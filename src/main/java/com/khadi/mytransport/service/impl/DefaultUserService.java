package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.converter.UserConverter;
import com.khadi.mytransport.dto.UserDto;
import com.khadi.mytransport.exception.PhoneNumberExistException;
import com.khadi.mytransport.model.User;
import com.khadi.mytransport.repository.UserRepository;
import com.khadi.mytransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public boolean login(String phoneNumber, String password) {
        return false;
    }

    @Override
    @Transactional
    public User register(UserDto user) throws PhoneNumberExistException {
        if (isExist(user.getPhoneNumber())) {
            throw new PhoneNumberExistException("There is an account with such phone number: " + user.getPhoneNumber());
        }
        return userRepository.save(userConverter.convert(user));
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
