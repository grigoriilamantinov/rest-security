package com.security.soapcrud.users.services;

import com.security.soapcrud.users.entity.user.AddUserRequest;
import com.security.soapcrud.users.entity.user.AddUserResponse;
import com.security.soapcrud.users.entity.user.DeleteUserResponse;
import com.security.soapcrud.users.entity.user.GetAllUserResponse;
import com.security.soapcrud.users.entity.user.GetUserByLoginResponse;
import com.security.soapcrud.users.entity.user.UpdateUserRequest;
import com.security.soapcrud.users.entity.user.UpdateUserResponse;

public interface UserService {
    GetAllUserResponse getAll();

    AddUserResponse save(AddUserRequest request);

    UpdateUserResponse update(UpdateUserRequest request);

    GetUserByLoginResponse getByLogin(String id);

    DeleteUserResponse deleteByLogin(String id);
}
