package com.security.soapcrud.users.endpoints;

import com.security.soapcrud.users.entity.user.AddUserRequest;
import com.security.soapcrud.users.entity.user.AddUserResponse;
import com.security.soapcrud.users.entity.user.DeleteUserRequest;
import com.security.soapcrud.users.entity.user.DeleteUserResponse;
import com.security.soapcrud.users.entity.user.GetAllUserResponse;
import com.security.soapcrud.users.entity.user.GetUserByLoginRequest;
import com.security.soapcrud.users.entity.user.GetUserByLoginResponse;
import com.security.soapcrud.users.entity.user.UpdateUserRequest;
import com.security.soapcrud.users.entity.user.UpdateUserResponse;
import com.security.soapcrud.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://user.entity.users.securityrest.security.com";

    private final UserService userService;

    public UserEndpoint(
        @Autowired final UserService userService
    ) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByLoginRequest")
    @ResponsePayload
    public GetUserByLoginResponse getUserByLogin (@RequestPayload final GetUserByLoginRequest request) {
        return userService.getByLogin(request.getLogin());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    @ResponsePayload
    public GetAllUserResponse getAllUser() {
        return userService.getAll();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUserById(@RequestPayload final DeleteUserRequest request) {
        return userService.deleteByLogin(request.getLogin());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload final UpdateUserRequest request) {
        return userService.update(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload final AddUserRequest request) {
        return userService.save(request);
    }
}
