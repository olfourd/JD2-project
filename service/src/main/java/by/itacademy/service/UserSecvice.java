package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.dto.UserDto;
import by.itacademy.entity.User;

import javax.jws.soap.SOAPBinding;

public class UserSecvice {
    public UserDto getUser(long id){
        User user = new UserDao().readUserById(id);
        return new UserDto(user.getName(), user.getSecondName(), user.getMail());
    }
}
