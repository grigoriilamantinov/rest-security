package com.security.securityrest.users.services;

import com.security.securityrest.users.entity.user.AddUserRequest;
import com.security.securityrest.users.entity.user.AddUserResponse;
import com.security.securityrest.users.entity.user.DeleteUserResponse;
import com.security.securityrest.users.entity.user.GetAllUserResponse;
import com.security.securityrest.users.entity.user.GetUserByLoginResponse;
import com.security.securityrest.users.entity.user.UpdateUserRequest;
import com.security.securityrest.users.entity.user.UpdateUserResponse;

public interface UserService {
    GetAllUserResponse getAll();

    AddUserResponse save(AddUserRequest request);

    UpdateUserResponse update(UpdateUserRequest request);

    GetUserByLoginResponse getByLogin(String id);

    DeleteUserResponse deleteByLogin(String id);
}
