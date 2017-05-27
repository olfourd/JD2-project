package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.dto.UserDto;
import by.itacademy.entity.User;

/**
 * Created by цифра on 27.05.2017.
 */
public class UserSecvice {
    public UserDto getUser(long id){
        User user = new UserDao().getById(id);
        UserDto userDto = new UserDto(user.getName(), user.getSecondName(), user.getMail());
        return userDto;
    }
}
