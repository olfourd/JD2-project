package by.itacademy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by цифра on 27.05.2017.
 */
@ToString
public class UserDto {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String secondName;
    @Getter
    @Setter
    private String mail;

    public UserDto(String name, String secondName, String mail) {
        this.name = name;
        this.secondName = secondName;
        this.mail = mail;
    }
}
