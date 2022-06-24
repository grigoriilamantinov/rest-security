package com.security.securityrest.users.dto;

import com.security.securityrest.authority.entity.Authority;
import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserTransformer {
    private String login;
    private String name;

    public static User of(final UserEntity userEntity) {
        final User user = new User();
        user.setLogin(userEntity.getLogin());
        user.setName(userEntity.getFirstName());

        var roleList = userEntity.getRolesList().stream()
            .map(Authority::getRole)
            .collect(Collectors.toList());

        roleList.forEach(role -> user.getAuthority().add(role));
        return user;
    }
}

