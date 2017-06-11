package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.dto.UserDto;
import by.itacademy.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSecvice {

    public UserDto getUser(long id){
        User user = UserDao.getInstance().readById(id);

        UserDto result = new UserDto(user.getName());
        return result;
    }
}
