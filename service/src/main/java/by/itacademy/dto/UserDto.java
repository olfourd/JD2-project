package by.itacademy.dto;

import lombok.Data;

/**
 * Created by цифра on 27.05.2017.
 */
@Data
public class UserDto {
    private String name;
    private String secondName;
    private String mail;

    public UserDto(String name, String secondName, String mail) {
        this.name = name;
        this.secondName = secondName;
        this.mail = mail;
    }
}
