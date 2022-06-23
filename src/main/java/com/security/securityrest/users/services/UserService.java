package com.security.securityrest.users.services;

import com.security.securityrest.users.entity.user.User;
import com.security.securityrest.users.entity.user.UserList;

import java.util.List;

public interface UserService {
    UserList getAll();

    void save(User user);

    User getById(String id);

    void delete(String id);
}
