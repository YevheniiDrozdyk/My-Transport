package com.khadi.mytransport.converter;

import com.khadi.mytransport.dto.UserDto;
import com.khadi.mytransport.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserConverter {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public User convert(UserDto userDto) {
        User user = new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        LocalDate birthDay = LocalDate.parse(userDto.getBirthDay(), formatter);
        user.setBirthDay(birthDay);
        user.setAddress(userDto.getAddress());

        return user;
    }
}
