package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDto {
    @Getter
    @Setter
    private String name;
}
