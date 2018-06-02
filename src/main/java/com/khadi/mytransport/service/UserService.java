package com.khadi.mytransport.service;

import com.khadi.mytransport.model.User;

public interface UserService {

    boolean login(String phoneNumber, String password);

    void register(User user);

    boolean isExist(String phoneNumber);

    User get(long id);

    User get(String phoneNumber);

}
