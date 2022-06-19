package com.security.securityrest.users.services;

import com.security.securityrest.common.SecurityRestCRUD;
import com.security.securityrest.users.dto.UserWithNameDTO;
import com.security.securityrest.users.entity.User;

import java.util.List;

public interface UserService extends SecurityRestCRUD<User> {
    List<UserWithNameDTO> getAllUserWithName();

    @Override
    List<User> getAll();

    @Override
    void save(User user);

    @Override
    User getById(int id);

    @Override
    void delete(int id);
}
