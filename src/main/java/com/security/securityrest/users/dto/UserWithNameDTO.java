package com.security.securityrest.users.dto;

import com.security.securityrest.users.entity.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor

public class UserWithNameDTO {
    private String login;
    private String name;

    public static UserWithNameDTO of (User user) {
        return new UserWithNameDTO(
            user.getLogin(),
            user.getFirstName()
        );
    }
}

