package com.security.securityrest.users.dto;

import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.UserList;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserListTransformer {
    private final String name;
    private final String login;
    private static final String SPACE = " ";

    public static UserList of(final List<UserEntity> userEntities) {
        final UserList userList = new UserList();
        for (final UserEntity user : userEntities) {
            userList
                .getUsersValueList()
                .add(user.getFirstName() + SPACE + user.getLogin());
        }
        return userList;
    }
}

