package com.khadi.mytransport.converter;

import com.khadi.mytransport.dto.UserDto;
import com.khadi.mytransport.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {
        User user = new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDay(user.getBirthDay());
        user.setAddress(user.getAddress());

        return user;
    }
}
