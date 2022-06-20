package com.security.securityrest.users.dto;

import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserTransformer {
    private String login;
    private String name;

    public static User of (UserEntity userEntity) {
        User user = new User();
        user.setLogin(userEntity.getLogin());
        user.setName(userEntity.getFirstName());
        return user;
    }
}

