package com.security.securityrest.users.services;

import com.security.securityrest.common.SecurityRestCRUD;
import com.security.securityrest.users.entity.UserEntity;


import java.util.List;

public interface UserService extends SecurityRestCRUD<UserEntity> {
    @Override
    List<UserEntity> getAll();

    @Override
    void save(UserEntity user);

    UserEntity getById(String id);

    void delete(String id);
}
